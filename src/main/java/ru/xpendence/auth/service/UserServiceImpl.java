package ru.xpendence.auth.service;

import com.google.common.collect.Lists;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.xpendence.auth.base.Active;
import ru.xpendence.auth.base.RoleType;
import ru.xpendence.auth.entity.User;
import ru.xpendence.auth.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 10:57
 * e-mail: v.chernyshov@pflb.ru
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository,
                           BCryptPasswordEncoder encoder,
                           RoleService roleService) {
        this.repository = repository;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    @Override
    public User register(User user) {
        return repository.save(new User(
                user.getUsername(),
                user.getPassword(),
                Active.ENABLED,
                Lists.newArrayList(roleService.getByType(RoleType.USER))
        ));
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("user not found by username: " + username));
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found by id: " + id));
    }
}
