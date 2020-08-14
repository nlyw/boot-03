package com.chenjh.service.user.impl;

import com.chenjh.entity.user.User;
import com.chenjh.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = userMapper.loadUserByUsername(s);
        if (null == u) {
            throw new UsernameNotFoundException("用户不存在");
        }
        u.setPassword("{noop}" + u.getPassword());
        return u;
    }
}
