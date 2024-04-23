package ca.johnholloway.service;

import ca.johnholloway.model.Comment;
import ca.johnholloway.processor.CommentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CommentService {


    // private ApplicationContext applicationContext;

    //Currently set to
    private CommentProcessor cp1;
    private CommentProcessor cp2;
    private Boolean b;

    public CommentService(){
        System.out.println("Comment Service created with no args!");

    }


    @Autowired
    public CommentService(ApplicationContext applicationContext){
        System.out.println("Comment Service created with context args!");

        this.cp1  = applicationContext.getBean(CommentProcessor.class);
        this.cp2  = applicationContext.getBean(CommentProcessor.class);
        System.out.println("cp1 and cp2 created");
        b = cp1 == cp2;
        System.out.println("cp1 == cp2: " + b + "\n");
    }

    public void letsRock(){


        Comment c1 = new Comment();
        Comment c2 = new Comment();

        System.out.println("Comments c1 and c2 created");
        cp1.setComment(c1);
        cp2.setComment(c2);
        cp1.setTitle("Cp1 title");
        cp1.setText("Cp1 text");
        cp2.setTitle("Cp2 title");
        cp1.save();
        cp2.setText("Cp2 text");
        cp2.save();

        if(b){
            System.out.println("\nCp1 and cp2 are using a singleton instance the class CommentProcessor\n" +
                    "As a result we are encountering mutability issues when we pass two comments into the two instance objects of the class.\n" +
                    "Were this a multithreaded application it could result in a race condition. In this project it assigns & prints the title and text in an incorrect matter.\nData corruption.");
        } else {
            System.out.println("\nCp1 and cp2 are using prototypes of the class CommentProcessor.\n"
            + "Because of this we can have two seperate instances of the CommentProcessor class we don't run into the same issue with mutability\n" +
                    "Were this a multithreaded app we would avoid the race condition. \nIn this project it assigns & prints the title and text correctly. ");
        }

    }

}
