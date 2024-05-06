package ca.johnholloway.chap14.services;

import ca.johnholloway.chap14.exceptions.AccountNotFoundException;
import ca.johnholloway.chap14.models.Account;
import ca.johnholloway.chap14.repositories.AccountRepository;
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
    public void TransferMoney(
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

        return accountRepository.findAccountsByName(name);
    }


}
