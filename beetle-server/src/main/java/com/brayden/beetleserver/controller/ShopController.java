package com.brayden.beetleserver.controller;

import com.brayden.beetleserver.domain.ShopBean;
import com.brayden.beetleserver.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private String port;

    @GetMapping("/getShopList")
    @ResponseBody
    public List<ShopBean> getShopList() {
        return shopService.getShopList();
    }

    @PostMapping("/saveShop")
    @ResponseBody
    public String saveShop(@RequestBody ShopBean shopBean) {
        String result = shopService.saveShop(shopBean);
        return result + "data from port=" + port;
    }

    @PostMapping("/postTest")
    @ResponseBody
    public String postTest(@RequestBody String requestBody){
        return shopService.postTest(requestBody);
    }
}
