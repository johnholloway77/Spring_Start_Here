package ca.johnholloway.chap13.services;

import ca.johnholloway.chap13.models.Account;
import ca.johnholloway.chap13.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;
    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Transactional //annotation can be used on class to apply to all methods if desired
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount){

        Account sender = accountRepository.findAccountById(idSender);
        Account reciever = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = reciever.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    @Transactional
    public void transferMoneyBad(long idSender, long idReceiver, BigDecimal amount) {

        Account sender = accountRepository.findAccountById(idSender);
        Account reciever = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = reciever.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

        //calling this method should intentionally invoke an exception
        throw new RuntimeException("Oh no! Something went wrong!");
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAllAccounts();
    }

}
