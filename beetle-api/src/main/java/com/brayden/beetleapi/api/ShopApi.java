package com.brayden.beetleapi.api;

import com.brayden.beetleapi.domain.ShopBean;
import com.brayden.beetleapi.server.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;


/**
 * @author: Brayden
 * @create: 2019-10-21 09:53
 * 通过feign调用接口,feign里面是包含负载均衡(ribbon);
 */
@RestController
public class ShopApi {

    @Autowired
    private ShopService shopService;

    @GetMapping("/v1/shop/list")
    public String  getShopList(){
        String byId = shopService.getShopList();
        return  byId;
    }

    @GetMapping("/v1/shop/save")
    public String  saveShop(){
        ShopBean shopBean = new ShopBean("friut", "down");
        return  shopService.saveShop(shopBean);
    }


    @PostMapping("/v1/postTest")
    public String  postTest(@RequestBody String requestBody, HttpServletRequest request){
        //当前线程睡眠一秒
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return shopService.postTest(requestBody);

    }
}
