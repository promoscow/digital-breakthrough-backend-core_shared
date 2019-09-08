package ru.xpendence.auth.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.19
 * Time: 15:49
 * e-mail: v.chernyshov@pflb.ru
 */
@Data
public class LoginDto implements Serializable {

    private String username;
    private String password;
}
