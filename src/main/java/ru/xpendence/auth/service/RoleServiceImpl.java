package ru.xpendence.auth.service;

import org.springframework.stereotype.Service;
import ru.xpendence.auth.base.RoleType;
import ru.xpendence.auth.entity.Role;
import ru.xpendence.auth.repository.RoleRepository;

import javax.persistence.EntityNotFoundException;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 11:03
 * e-mail: v.chernyshov@pflb.ru
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role getByType(RoleType roleType) {
        return repository.findByRoleType(roleType)
                .orElseThrow(() -> new EntityNotFoundException("role not found by type: " + roleType.name()));
    }
}
