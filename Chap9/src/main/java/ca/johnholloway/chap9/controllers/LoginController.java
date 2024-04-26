package ca.johnholloway.chap9.controllers;

import ca.johnholloway.chap9.processors.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;
    public LoginController(LoginProcessor loginProcessor){
        this.loginProcessor = loginProcessor;
    }

    private final Logger logger = Logger.getLogger(LoginController.class.getName());


    @GetMapping(value={"/login", "/"})
    public String getLogin(){
        logger.info("/login requested");

        return "login";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = loginProcessor.login();

        if(loggedIn){
            //model.addAttribute("message", "You're logged in");
            return "redirect:/main";
            /*
            Note to self:
                return "main"; and return "redirect:/main"; are two different things!
                The former will simply send the user to the thymeleaf main.html template
                The latter will send the http GET request via the MainController, running its functions.
             */

        }else{
            model.addAttribute("message", "Login failed");

            return "login";
        }

    }
}
