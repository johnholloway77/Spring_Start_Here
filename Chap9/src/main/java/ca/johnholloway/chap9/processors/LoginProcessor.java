package ca.johnholloway.chap9.processors;

import ca.johnholloway.chap9.service.LoggedUserManagementService;
import ca.johnholloway.chap9.service.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    private String username;
    private String password;

    public LoginProcessor(
            LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService  = loginCountService;
    }

    public boolean login(){
        loginCountService.increment();

        String username = this.getUsername();
        String password = this.getPassword();

        if("natalie".equals(username) && "password".equals(password)){
            loggedUserManagementService.setUsername(username);
            return true;
        } else {
            return false;
        }

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
