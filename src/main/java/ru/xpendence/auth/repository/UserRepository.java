package ru.xpendence.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.auth.entity.User;

import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 10:54
 * e-mail: v.chernyshov@pflb.ru
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
