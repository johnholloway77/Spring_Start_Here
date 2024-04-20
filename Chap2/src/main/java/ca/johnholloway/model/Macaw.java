package ca.johnholloway.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/* using @Component annotation is called stereotyping. It allows us to insert an instance of
    the object with fewer lines of code.
    The Spring base just needs to be configured to scan for components
 */
@Component
public class Macaw {

    private String name;

    //use @PostConstruct to modify the object upon creation b
    @PostConstruct
    public void init(){
        this.name = "Polly";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
