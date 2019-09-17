package ru.xpendence.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.auth.entity.RegistrationToken;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.09.19
 * Time: 20:56
 * e-mail: v.chernyshov@pflb.ru
 */
public interface RegistrationTokenRepository extends JpaRepository<RegistrationToken, Long> {
}
