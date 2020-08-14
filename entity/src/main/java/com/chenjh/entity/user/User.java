package com.chenjh.entity.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

    private int id;

    private String username;

    private String password;

    private Boolean enabled;

    private boolean locked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 将roles进行整理
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // 角色认证的要求，角色名必须是ROLE_开始的（如果数据库中查出来的数据就是ROLE开始，该字符串可以省略）
        authorities.add(new SimpleGrantedAuthority("ROLE_超级管理员"));
        //授予修改店铺的权限
        authorities.add(new SimpleGrantedAuthority("店铺:修改"));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        //是否不过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //是否不上锁
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
