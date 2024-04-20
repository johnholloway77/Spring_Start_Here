package ca.johnholloway.main;

import ca.johnholloway.config.ProjectConfig;
import ca.johnholloway.model.Macaw;
import ca.johnholloway.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        //create an instance of Spring context
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //without using name, we get the primary bean
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
        System.out.println(p.speak());

        //use the name of the method to get the specific bean
        Parrot p2 = context.getBean("parrot2", Parrot.class);
        System.out.println(p2.speak());

        //use the name of the bean to get the specific instance
        Parrot p3 = context.getBean("Capt. Riki", Parrot.class);
        System.out.println(p3.speak());

        Macaw m = context.getBean(Macaw.class);
        //The annotation @PostConstruct initialized the Macaw object with a default name
        //m.setName("Polly");
        System.out.println("\nThe name of the macaw is " + m.getName());

        System.out.println("");

        //creating bean programatically
        Macaw m2 = new Macaw();
        m2.setName("Molly");
        Supplier<Macaw> macawSupplier = () -> m2;
        context.registerBean("macawM", Macaw.class, macawSupplier);
        Macaw mM = context.getBean("macawM", Macaw.class);
        System.out.println("The name of the macaw is " + mM.getName());



        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println("Integer is " + n);

    }
}