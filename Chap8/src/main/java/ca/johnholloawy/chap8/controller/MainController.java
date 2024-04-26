package ca.johnholloawy.chap8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


//    @RequestMapping("/home")
//    public String home(@RequestParam(required = false) String color, @RequestParam(required = true) String name, Model page){
//        page.addAttribute("username", name);
//        page.addAttribute("color", color);
//        return "home.html";
//    }

    @RequestMapping("/home/{color}")
    public String home(@PathVariable String color, Model page){
        page.addAttribute("username", "Katy");
        page.addAttribute("color", color);
        return "home.html";
    }

}
