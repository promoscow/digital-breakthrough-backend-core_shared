package ru.xpendence.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.09.19
 * Time: 19:58
 * e-mail: v.chernyshov@pflb.ru
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "registration_tokens")
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationToken extends AbstractEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "token")
    private String token;

    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;
}
