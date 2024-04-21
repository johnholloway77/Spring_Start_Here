package ca.holloway.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ca.holloway.proxy", "ca.holloway.repository", "ca.holloway.service"})
public class ProjectConfig {

}
