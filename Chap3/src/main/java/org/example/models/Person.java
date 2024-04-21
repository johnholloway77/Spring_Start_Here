package org.example.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Ella";

    //example of field injection
//    @Autowired //use autowire to inject parrot bean into person object.
//    private Parrot parrot;

    private final Parrot parrot;
    private final Parrot p2;

    //example of constructor injection
//    @Autowired
    public Person(Parrot parrot, @Qualifier("parrot2") Parrot parrot2){
        this.parrot = parrot;
        this.p2 = parrot2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public Parrot getParrot2() {
        return p2;
    }

//    example of settor injections. Not recommended
//    @Autowired
//    public void setParrot(Parrot parrot) {
//        this.parrot = parrot;
//    }

}
