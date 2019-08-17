package ru.xpendence.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 11:43
 * e-mail: v.chernyshov@pflb.ru
 */
public class JwtAuthenticationException extends AuthenticationException {

    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
