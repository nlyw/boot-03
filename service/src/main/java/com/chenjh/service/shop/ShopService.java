package com.chenjh.service.shop;

import com.chenjh.entity.shop.Shop;

import java.util.Map;

public interface ShopService {
    Map<String,Object> selectShopList(Shop shop);

    Shop selectShopInfoByID(Shop shop);

    void updateShopInfoByID(Shop shop);
}
