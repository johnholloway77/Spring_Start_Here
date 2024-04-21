package org.example.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//@Component //for autowire we set it to component
public class Parrot {

    private String name = "Koko";


//    //Example of a circular dependancy. Parrot depends on Person, but person depends on parrot.
//    final private Person p;
//    @Autowired
//    public Parrot(Person p){
//        this.p = p;
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
