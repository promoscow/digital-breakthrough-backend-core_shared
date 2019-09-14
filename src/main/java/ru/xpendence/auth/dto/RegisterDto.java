package ru.xpendence.auth.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 10.09.19
 * Time: 21:31
 * e-mail: v.chernyshov@pflb.ru
 */
@Data
public class RegisterDto implements Serializable {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    private String email;
}
