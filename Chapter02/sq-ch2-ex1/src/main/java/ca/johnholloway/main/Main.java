package ca.johnholloway.main;

import ca.johnholloway.config.ProjectConfig;
import ca.johnholloway.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        //create an instance of Spring context
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);

        System.out.println(p.getName());
        System.out.println(p.speak());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println("Integer is " + n);

    }
}