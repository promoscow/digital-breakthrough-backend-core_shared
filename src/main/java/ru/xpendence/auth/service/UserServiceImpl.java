package ru.xpendence.auth.service;

import com.google.common.collect.Lists;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.xpendence.auth.base.Active;
import ru.xpendence.auth.base.RoleType;
import ru.xpendence.auth.dto.UserDto;
import ru.xpendence.auth.entity.User;
import ru.xpendence.auth.mapper.UserMapper;
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
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository,
                           BCryptPasswordEncoder encoder,
                           RoleService roleService,
                           UserMapper mapper) {
        this.repository = repository;
        this.encoder = encoder;
        this.roleService = roleService;
        this.mapper = mapper;
    }

    @Override
    public User create(UserDto dto) {
        User user = mapper.toEntity(dto, new User());
        user.setActive(Active.ENABLED);
        user.setConfirmed(false);
        user.setRoles(Lists.newArrayList(roleService.getByType(RoleType.USER)));
        return repository.save(user);
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
