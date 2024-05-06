package ca.johnholloway.chap15.controllers;

import ca.johnholloway.chap15.dto.TransferRequest;
import ca.johnholloway.chap15.models.Account;
import ca.johnholloway.chap15.services.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
public class AccountController {

    private final Logger logger = Logger.getLogger(AccountController.class.getName());

    private final TransferService transferService;
    public AccountController(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest) {
        transferService.transferMoney(
                transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ){
        logger.info("param name = " + name);

        if(name == null){
            return transferService.getAllAccounts();
        } else{
            return transferService.findAccountsByName(name);
        }
    }

    @GetMapping("/john")
    public Account callJohn(){
        return  transferService.callJohn();
    }

}

/*

We can use the following commands with httpie:

$ http localhost:8080/accounts

HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Mon, 06 May 2024 04:43:20 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

[
    {
        "amount": 1000.0,
        "id": 1,
        "name": "Jane Down"
    },
    {
        "amount": 1000.0,
        "id": 2,
        "name": "John Doe"
    }
]

$ http POST localhost:8080/transfer senderAccountId=1 receiverAccountId=2 amount=100

HTTP/1.1 200
Connection: keep-alive
Content-Length: 0
Date: Mon, 06 May 2024 04:44:07 GMT
Keep-Alive: timeout=60



$ http localhost:8080/accounts

HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Mon, 06 May 2024 04:44:09 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

[
    {
        "amount": 900.0,
        "id": 1,
        "name": "Jane Down"
    },
    {
        "amount": 1100.0,
        "id": 2,
        "name": "John Doe"
    }
]





 */