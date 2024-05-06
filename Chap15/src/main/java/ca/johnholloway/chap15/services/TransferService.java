package ca.johnholloway.chap15.services;

import ca.johnholloway.chap15.exceptions.AccountNotFoundException;
import ca.johnholloway.chap15.models.Account;
import ca.johnholloway.chap15.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;


@Service
public class TransferService {

    private final Logger logger = Logger.getLogger(TransferService.class.getName());
    public final AccountRepository accountRepository;
    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


    @Transactional
    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount
    ) {
        //We're throwing exceptions instead of using Optional<Account>
        //Optional<Account> sender = accountRepository.findById(idSender);
        //Optional<Account> receiver = accountRepository.findById(idReceiver);

        Account sender = accountRepository.findById(idSender).orElseThrow(AccountNotFoundException::new);
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount= receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

    }


    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }



    public List<Account> findAccountsByName(String name){

        logger.info("String name = " + name);

        /*
        Old method:
        return accountRepository.findAccountsByName(name);

        Doesn't work as it expects a parameter for the exact name, eg: "John Doe"
        In order for it to work we have to use the exact name as a parameter, not just first name
        Requires "%20" for the space between first and last name

        eg:
        curl http://localhost:8080/accounts?name=John%20Doe

         */

        //return accountRepository.findAccountsByName(name);
        return accountRepository.findAccountsByNameContainingIgnoreCase(name);
    }

    public Account callJohn(){
        logger.info("running callJohn()");
        return accountRepository.callJohn();
    }


}
