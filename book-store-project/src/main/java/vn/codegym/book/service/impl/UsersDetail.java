package vn.codegym.book.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.codegym.book.model.Users;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UsersDetail implements UserDetails {
    private String username;
    private String password;
    private Boolean active;
    private List<GrantedAuthority> grantedAuthority;

    public UsersDetail() {
    }

    public UsersDetail(String username, String password, Boolean active, List<GrantedAuthority> grantedAuthority) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.grantedAuthority = grantedAuthority;
    }

    public static UsersDetail build(Users users){
        List<GrantedAuthority> grantedAuthorities = users.getUserRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoles().getName())).collect(Collectors.toList());
        return new UsersDetail(users.getUsername(),users.getPassword(),users.isActive(),grantedAuthorities);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthority;
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
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersDetail)) return false;
        UsersDetail that = (UsersDetail) o;
        return username.equals(that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
