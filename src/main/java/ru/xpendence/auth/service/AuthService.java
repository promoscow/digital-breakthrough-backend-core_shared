package ru.xpendence.auth.service;

import ru.xpendence.auth.dto.LoginDto;
import ru.xpendence.auth.dto.UserDto;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.19
 * Time: 15:48
 * e-mail: v.chernyshov@pflb.ru
 */
public interface AuthService {

    String login(LoginDto dto);

    boolean register(UserDto dto);

    String confirmEmail(String username, String token);
}
