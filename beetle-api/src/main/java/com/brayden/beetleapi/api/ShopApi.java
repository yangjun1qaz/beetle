package com.brayden.beetleapi.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.brayden.beetleapi.server.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Brayden
 * @create: 2019-10-21 09:53
 */
@RestController
public class ShopApi {

    @Autowired

    private ShopService shopService;

    @GetMapping("v1/shop/list")
    public String  getShopList(){
        String byId = shopService.findById();
        return  byId;
    }
}
