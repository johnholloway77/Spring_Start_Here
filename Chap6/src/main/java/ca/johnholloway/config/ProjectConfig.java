package ca.johnholloway.config;

import ca.johnholloway.aspect.LoggingAspect;
import ca.johnholloway.aspect.SecurityAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"ca.johnholloway.service", "ca.johnholloway.annotation"})
public class ProjectConfig {

    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }

    @Bean
    public SecurityAspect securityAspect(){
        return new SecurityAspect();
    }

}
