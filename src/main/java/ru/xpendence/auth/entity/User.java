package ru.xpendence.auth.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import ru.xpendence.auth.base.Active;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 10:45
 * e-mail: v.chernyshov@pflb.ru
 */
@Entity
@Table(name = "users")
@SQLDelete(sql = "update users set active = 0 where id = ?")
@Where(clause = "active = 1")
@EqualsAndHashCode(callSuper = true)
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "active")
    private Active active = Active.ENABLED;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles = new ArrayList<>();
}
