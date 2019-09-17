package ru.xpendence.auth.service;

import ru.xpendence.auth.entity.RegistrationToken;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.09.19
 * Time: 20:54
 * e-mail: v.chernyshov@pflb.ru
 */
public interface RegistrationTokenService {

    RegistrationToken create(RegistrationToken registrationToken);

    RegistrationToken getByUsernameAndToken(String username, String token);
}
