package org.example.config;

import org.example.models.Parrot;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example.models")
public class ProjectConfig {

    @Bean
    @Primary
    public Parrot parrot1(){
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Parrot parrot2(){
        Parrot p = new Parrot();
        p.setName("Moco");
        return p;
    }

    @Bean
    public Parrot parrot3(){
        Parrot p = new Parrot();
        p.setName("Poco");
        return p;
    }

//    @Bean
//    public Person person(
//            @Qualifier("parrot2") Parrot parrot2){
//        Person p = new Person();
//        p.setName("Ella");
//        //p.setParrot(parrot2); //defining a link between person p and the parrot created in parrot() function
//        return p;
//    }


}
