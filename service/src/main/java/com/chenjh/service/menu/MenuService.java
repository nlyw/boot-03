package com.chenjh.service.menu;

import com.chenjh.entity.menu.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> selectSideMenuList(Menu menu);
}
