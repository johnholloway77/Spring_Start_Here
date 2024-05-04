package ca.johnholloway.chap13.controllers;

import ca.johnholloway.chap13.models.Account;
import ca.johnholloway.chap13.models.TransferRequest;
import ca.johnholloway.chap13.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;
    public AccountController(TransferService transferService){
        this.transferService = transferService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return transferService.getAllAccounts();
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request //wtf is a DTO?!?
    ){
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );
    }

    @PostMapping("/transferbad")
    public void transferMoneyBad(
            @RequestBody TransferRequest request //wtf is a DTO?!?
    ){
        transferService.transferMoneyBad(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );
    }


}
