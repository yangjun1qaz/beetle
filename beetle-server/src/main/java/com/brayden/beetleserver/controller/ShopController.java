package com.brayden.beetleserver.controller;

import com.brayden.beetleserver.domain.ShopBean;
import com.brayden.beetleserver.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: Brayden
 * @create: 2019-10-18 14:03
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/getShopList")
    @ResponseBody
    public List<ShopBean> getShopList() {
        return shopService.getShopList();
    }


    @PostMapping("/postTest")
    @ResponseBody
    public String postTest(@RequestBody String requestBody){
        return shopService.postTest(requestBody);
    }
}
