package ca.johnholloway.config;

import ca.johnholloway.service.CommentService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.beans.BeanDescriptor;

@Configuration
@ComponentScan(basePackages = "ca.johnholloway")
public class ProjectConfig {



//    @Bean
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public CommentService  commentService(){
//        return new CommentService();
//    }
}
