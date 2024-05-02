package ca.johnholloway.chap11webclient.proxies;

import ca.johnholloway.chap11webclient.models.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentProxy {

    @Value("${name.service.url}")
    private String url;

    private final WebClient webClient;

    public PaymentProxy(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(
            String requestId,
            Payment payment){
        return webClient
                .post()
                .uri(url + "/payment")
                .header("requestId", requestId)
                .body(Mono.just(payment), Payment.class)
                .retrieve()
                .bodyToMono(Payment.class);
    }


}
