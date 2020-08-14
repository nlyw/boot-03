package com.chenjh.entity.shop;

import com.chenjh.common.util.PageUtil;

import java.io.Serializable;

public class Shop extends PageUtil implements Serializable {

    private int shopID;

    private String shopName;

    //金木水火土（1，2，3，4，5）
    private int shopType;

    private String shopTags;

    private int shopAddr;

    private String shopDateStr;

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getShopType() {
        return shopType;
    }

    public void setShopType(int shopType) {
        this.shopType = shopType;
    }

    public String getShopTags() {
        return shopTags;
    }

    public void setShopTags(String shopTags) {
        this.shopTags = shopTags;
    }

    public int getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(int shopAddr) {
        this.shopAddr = shopAddr;
    }

    public String getShopDateStr() {
        return shopDateStr;
    }

    public void setShopDateStr(String shopDateStr) {
        this.shopDateStr = shopDateStr;
    }
}
