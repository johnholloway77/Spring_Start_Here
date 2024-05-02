package ca.johnholloway.chap11webclient.controllers;

import ca.johnholloway.chap11webclient.models.Payment;
import ca.johnholloway.chap11webclient.proxies.PaymentProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class PaymentController {

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy){
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Mono<Payment> createPayment(
            @RequestBody Payment payment
    ){
        String requestId = UUID.randomUUID().toString();
        return paymentProxy.createPayment(requestId, payment);
    }

}
