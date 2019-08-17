package ru.xpendence.auth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.xpendence.auth.base.Active;
import ru.xpendence.auth.entity.Role;
import ru.xpendence.auth.entity.User;

import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 11:27
 * e-mail: v.chernyshov@pflb.ru
 */
public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final Date lastPasswordResetDate;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    private JwtUser(Long id,
                    String username,
                    String password,
                    Date lastPasswordResetDate,
                    boolean enabled,
                    Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                Date.from(user.getUpdated().toInstant(ZoneOffset.UTC)),
                user.getActive().equals(Active.ENABLED),
                mapGrantedAuthorities(user.getRoles())
        );
    }

    private static List<GrantedAuthority> mapGrantedAuthorities(List<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRoleType().name())).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
        return id;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
