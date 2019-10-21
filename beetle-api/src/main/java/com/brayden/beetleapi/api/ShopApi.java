package com.brayden.beetleapi.api;

import com.brayden.beetleapi.server.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author: Brayden
 * @create: 2019-10-21 09:53
 */
@RestController
public class ShopApi {

    @Autowired
    private ShopService shopService;

    @GetMapping("/v1/shop/list")
    public String  getShopList(){
        String byId = shopService.findById();
        return  byId;
    }
    @PostMapping("/v1/postTest")
    public String  postTest(@RequestBody String requestBody, HttpServletRequest request){
        return shopService.postTest(requestBody);
    }
}
