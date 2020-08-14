package com.chenjh.controller.index;

import com.chenjh.entity.menu.Menu;
import com.chenjh.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    String index(Model model, Menu menu) {
        //查询左侧导航树（侧边栏）
        List<Menu> mlist = menuService.selectSideMenuList(menu);

        model.addAttribute("mlist", mlist);
        return "index";
    }

    @RequestMapping("toLogin")
    String toLogin() {
        return "login";
    }

    @RequestMapping("401")
    String wqx() {
        return "401";
    }

}
