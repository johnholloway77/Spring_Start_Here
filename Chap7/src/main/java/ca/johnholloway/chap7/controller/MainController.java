package ca.johnholloway.chap7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class MainController {

    private Logger logger = Logger.getLogger(MainController.class.getName());

    @RequestMapping("/home")
    public String home(){
        logger.info("\tSome asshole visted home!");
        return "home.html";
    }
}
