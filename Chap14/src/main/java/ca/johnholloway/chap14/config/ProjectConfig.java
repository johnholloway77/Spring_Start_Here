package ca.johnholloway.chap14.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

    @Value("${custom.datasource.url}")
    private String dataSourceUrl;

    @Value("${custom.datasource.username}")
    private String dataSourceUsername;

    @Value("${custom.datasource.password}")
    private String dataSourcePassword;

    @Bean
    public DataSource dataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setJdbcUrl(dataSourceUrl);
        hikariDataSource.setUsername(dataSourceUsername);
        hikariDataSource.setPassword(dataSourcePassword);
        hikariDataSource.setConnectionTimeout(1000);

        return hikariDataSource;
    }
}
