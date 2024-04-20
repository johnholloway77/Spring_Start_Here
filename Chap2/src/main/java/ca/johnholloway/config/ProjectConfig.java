package ca.johnholloway.config;

import ca.johnholloway.model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "ca.johnholloway.model")
public class ProjectConfig {

    //set Koko to primary bean
    @Bean
    @Primary
    Parrot parrot1(){
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    Parrot parrot2(){
        var p = new Parrot();
        p.setName("Miki");
        return p;
    }

    //use an alternative name rather than method name to identify bean
    @Bean(name = "Capt. Riki")
    Parrot parrot3(){
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }

    @Bean
    String Hello(){
        return "Hello World!";
    }

    @Bean
    Integer ten(){
        return 10;
    }

}
