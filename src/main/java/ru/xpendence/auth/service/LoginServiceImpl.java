package ru.xpendence.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.xpendence.auth.dto.LoginDto;
import ru.xpendence.auth.entity.User;
import ru.xpendence.auth.security.JwtTokenService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.19
 * Time: 15:50
 * e-mail: v.chernyshov@pflb.ru
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final UserService userService;

    public LoginServiceImpl(AuthenticationManager authenticationManager,
                            JwtTokenService jwtTokenService,
                            UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
    }

    @Override
    public String login(LoginDto dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        User user = userService.findByUsername(dto.getUsername());
        return jwtTokenService.createToken(dto.getUsername(), user.getRoles());
    }
}
