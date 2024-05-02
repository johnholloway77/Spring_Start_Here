package ca.johnholloway.chap11resttemplate.controllers;

import ca.johnholloway.chap11resttemplate.models.Payment;
import ca.johnholloway.chap11resttemplate.proxies.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentsController {

    private final Logger logger = Logger.getLogger(PaymentsController.class.getName());
    private final PaymentsProxy paymentsProxy;
    public PaymentsController(PaymentsProxy paymentsProxy){
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ){
        logger.info("\tpaymentsProxy triggered to create new RestTemplate");
        return paymentsProxy.createPayment(payment);
    }
}
