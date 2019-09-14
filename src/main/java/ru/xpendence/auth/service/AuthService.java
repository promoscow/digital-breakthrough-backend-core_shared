package ru.xpendence.auth.service;

import ru.xpendence.auth.dto.LoginDto;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.19
 * Time: 15:48
 * e-mail: v.chernyshov@pflb.ru
 */
public interface AuthService {

    String login(LoginDto dto);
}
