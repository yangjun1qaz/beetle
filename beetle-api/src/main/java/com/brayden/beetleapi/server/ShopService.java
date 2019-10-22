package com.brayden.beetleapi.server;

import com.brayden.beetleapi.domain.ShopBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Brayden
 * @create: 2019-10-21 10:22
 */
@FeignClient(name = "beetle-server")
public interface ShopService {

    @GetMapping("/shop/getShopList")
    String findById();

    @PostMapping("/shop/saveShop")
    String saveShop(@RequestBody ShopBean shopBean);

    @PostMapping("/shop/postTest")
    String postTest(String requestBody);

}
