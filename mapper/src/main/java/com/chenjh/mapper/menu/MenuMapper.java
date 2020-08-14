package com.chenjh.mapper.menu;

import com.chenjh.entity.menu.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select(" select m.t_id id, m.t_text text," +
            " m.t_href href, m.t_pid pid, m.t_type type" +
            " from t_menus m" +
            " where m.t_pid = #{pid}" +
            " and m.t_type = 'nav'")
    List<Menu> selectSideMenuList(Menu menu);
}
