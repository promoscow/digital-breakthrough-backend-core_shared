package ru.xpendence.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.auth.base.RoleType;
import ru.xpendence.auth.entity.Role;

import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 10:55
 * e-mail: v.chernyshov@pflb.ru
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType roleType);
}
