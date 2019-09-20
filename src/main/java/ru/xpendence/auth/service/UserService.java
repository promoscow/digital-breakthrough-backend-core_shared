package ru.xpendence.auth.service;

import ru.xpendence.auth.dto.UserDto;
import ru.xpendence.auth.entity.User;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 10:56
 * e-mail: v.chernyshov@pflb.ru
 */
public interface UserService {

    User create(UserDto dto);

    User save(User user);

    User findByUsername(String username);

    User findById(Long id);

    User confirm(User user);
}
