package ru.xpendence.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.xpendence.auth.dto.EmailMessageDto;
import ru.xpendence.auth.dto.LoginDto;
import ru.xpendence.auth.dto.ResponseDto;
import ru.xpendence.auth.dto.UserDto;
import ru.xpendence.auth.entity.RegistrationToken;
import ru.xpendence.auth.entity.User;
import ru.xpendence.auth.security.JwtTokenService;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.19
 * Time: 15:50
 * e-mail: v.chernyshov@pflb.ru
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final UserService userService;
    private final RegistrationTokenService registrationTokenService;
    private final RestTemplate restTemplate;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           JwtTokenService jwtTokenService,
                           UserService userService,
                           RegistrationTokenService registrationTokenService,
                           RestTemplate restTemplate) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.registrationTokenService = registrationTokenService;
        this.restTemplate = restTemplate;
    }

    @Override
    public String login(LoginDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(),
                        dto.getPassword())
        );
        User user = userService.getByUsername(dto.getUsername());
        return jwtTokenService.createToken(dto.getUsername(), user.getRoles());
    }

    @Override
    public boolean register(UserDto dto) {
        User user = userService.create(dto);
        RegistrationToken registrationToken = registrationTokenService.create(
                new RegistrationToken(
                        user.getUsername(),
                        RandomStringUtils.randomAlphanumeric(64),
                        LocalDateTime.now().plusHours(2L)
                )
        );
        String url = "http://message:8082/email";
        EmailMessageDto request = new EmailMessageDto(
                dto.getEmail(),
                "slava_rossii@list.ru",
                "Подтверждение регистрации",
                "Для завершения регистрации пройдите по ссылке: http://digital.lambdacoders.ru/confirm?username="
                        + registrationToken.getUsername() + "&token=" + registrationToken.getToken()
        );
        log.info("sending message to url {}: {}", url, request);
        ResponseDto response = restTemplate.postForObject(
                url,
                request,
                ResponseDto.class
        );
        return Objects.nonNull(response) ? response.getSuccess() : false;
    }

    @Override
    @Transactional
    public String confirmEmail(String username, String token) {
        registrationTokenService.getByUsernameAndToken(username, token);
        User user = userService.getByUsername(username);
        userService.confirm(user);
        return jwtTokenService.createToken(username, user.getRoles());
    }
}
