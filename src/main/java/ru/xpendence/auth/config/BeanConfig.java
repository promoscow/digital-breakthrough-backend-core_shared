package ru.xpendence.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 11:00
 * e-mail: v.chernyshov@pflb.ru
 */
@Configuration
public class BeanConfig {

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
