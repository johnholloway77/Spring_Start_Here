package org.example;

import org.example.config.ProjectConfig;
import org.example.models.Parrot;
import org.example.models.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
       // Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name " + person.getName());
        //System.out.println("Parrot's name: " + parrot.getName());
        System.out.println(person.getName() + "'s parrots: " + person.getParrot().getName() + " and " + person.getParrot2().getName());


    }
}