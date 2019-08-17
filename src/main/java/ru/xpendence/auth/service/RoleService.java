package ru.xpendence.auth.service;

import ru.xpendence.auth.base.RoleType;
import ru.xpendence.auth.entity.Role;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 11:02
 * e-mail: v.chernyshov@pflb.ru
 */
public interface RoleService {

    Role getByType(RoleType roleType);
}
