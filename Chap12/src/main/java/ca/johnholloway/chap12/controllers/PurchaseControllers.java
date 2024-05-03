package ca.johnholloway.chap12.controllers;

import ca.johnholloway.chap12.models.Purchase;
import ca.johnholloway.chap12.repositories.PurchaseRespository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseControllers {

    private final PurchaseRespository purchaseRespository;
    public PurchaseControllers(PurchaseRespository purchaseRespository){
        this.purchaseRespository = purchaseRespository;
    }

    @PostMapping
    public void storePurchase(
            @RequestBody Purchase purchase
    ){
        purchaseRespository.storePurchase(purchase);
    }


    @GetMapping
    public List<Purchase> findPurchases(){
        return purchaseRespository.finalAllPurchases();
    }

}
