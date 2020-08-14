package com.chenjh.service.shop.impl;

import com.chenjh.entity.shop.Shop;
import com.chenjh.mapper.shop.ShopMapper;
import com.chenjh.service.shop.ShopService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Map<String, Object> selectShopList(Shop shop) {
        Map<String, Object> map = new HashMap<>();
        //开启分页
        Page<Object> page = PageHelper.startPage(shop.getPage(), shop.getLimit());
        List<Shop> list = shopMapper.selectShopList(shop);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", page.getTotal());
        map.put("data", list);
        return map;
    }

    @Override
    public Shop selectShopInfoByID(Shop shop) {
        return shopMapper.selectShopInfoByID(shop);
    }

    @Override
    public void updateShopInfoByID(Shop shop) {
        shopMapper.updateShopInfoByID(shop);
    }
}
