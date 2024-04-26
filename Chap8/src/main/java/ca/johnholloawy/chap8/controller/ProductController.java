package ca.johnholloawy.chap8.controller;

import ca.johnholloawy.chap8.model.Product;
import ca.johnholloawy.chap8.service.ProductServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductServices productServices;

    public ProductController(ProductServices productServices){
        this.productServices = productServices;
    }

    @GetMapping(value = "/products")
    public String viewProducts(Model model){
        var products = productServices.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    //Spring can receive a model as a paramater
    //the constructor arguments are inferred via the parameter names in the form.
    @PostMapping(value = "/products")
    public String addProduct(
//            @RequestParam String name,
//            @RequestParam double price,
            Product p,
            Model model
    ){
//        Product p = new Product();
//        p.setName(name);
//        p.setPrice(price);
        productServices.addProduct(p);

        var products = productServices.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
