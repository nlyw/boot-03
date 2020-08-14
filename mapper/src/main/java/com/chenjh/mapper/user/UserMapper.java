package com.chenjh.mapper.user;

import com.chenjh.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select(" select t_id id, t_name username," +
            " t_pwd password" +
            " from t_users" +
            " where t_name = #{username}")
    User loadUserByUsername(String s);
}
