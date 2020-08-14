package com.chenjh.controller.shop;

import com.chenjh.entity.shop.Shop;
import com.chenjh.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping("shop/toList.do")
    String toShopListPage() {
        return "shop/list";
    }

    @RequestMapping("shop/list")
    @ResponseBody
    Map<String, Object> selectShopList(Shop shop) {
        Map<String, Object> map = shopService.selectShopList(shop);
        return map;
    }

    @RequestMapping("shop/toEdit")
    String toEditPage(Shop shop, Model model) {
        Shop s = shopService.selectShopInfoByID(shop);
        model.addAttribute("shop", s);
        return "shop/edit";
    }

    @RequestMapping("shop/edit")
    @ResponseBody
    @PreAuthorize("hasAuthority('店铺:修改')")
    String updateShopInfoByID(Shop shop) {
        shopService.updateShopInfoByID(shop);
        return "{}";
    }
}
