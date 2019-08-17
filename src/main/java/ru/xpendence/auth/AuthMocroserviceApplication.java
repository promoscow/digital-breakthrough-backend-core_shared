package ru.xpendence.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(
        value = {
                @PropertySource(value = "classpath:auth.properties")
        }
)
public class AuthMocroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthMocroserviceApplication.class, args);
    }

}
