package dev.ddanylenko.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Scanner;

@PropertySource("classpath:application.properties")
@Configuration
public class PropertiesConfiguration {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

}
