package ru.xpendence.auth.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.xpendence.auth.service.UserService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 11:25
 * e-mail: v.chernyshov@pflb.ru
 */
@Service
public class JwtDetailsService implements UserDetailsService {

    private final UserService userService;

    public JwtDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return JwtUser.create(userService.getByUsername(username));
    }
}
