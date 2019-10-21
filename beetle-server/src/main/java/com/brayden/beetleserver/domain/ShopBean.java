package com.brayden.beetleserver.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Brayden
 * @create: 2019-10-18 10:52
 */
@Data
public class ShopBean implements Serializable {

    /**
     * 商铺名称
     */
    private String shopName;

    /**
     * 商铺位置
     */
    private String shopLocation;

    public ShopBean(String shopName, String shopLocation) {
        this.shopName = shopName;
        this.shopLocation = shopLocation;
    }
}
