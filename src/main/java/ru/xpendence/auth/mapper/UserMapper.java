package ru.xpendence.auth.mapper;

import org.springframework.stereotype.Component;
import ru.xpendence.auth.dto.UserDto;
import ru.xpendence.auth.entity.User;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.09.19
 * Time: 20:22
 * e-mail: v.chernyshov@pflb.ru
 */
@Component
public class UserMapper {

    public User toEntity(UserDto dto, User user) {
        whenNotNull(dto.getId(), user::setId);
        whenNotNull(dto.getUsername(), user::setUsername);
        whenNotNull(dto.getPassword(), user::setPassword);
        whenNotNull(dto.getFirstName(), user::setFirstName);
        whenNotNull(dto.getLastName(), user::setLastName);
        whenNotNull(dto.getEmail(), user::setEmail);
        return user;
    }

    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    private <T> void whenNotNull(T o, Consumer<T> c) {
        if (Objects.nonNull(o)) {
            if (o instanceof String && ((String) o).isEmpty()) {
            } else {
                c.accept(o);
            }
        }
    }
}
