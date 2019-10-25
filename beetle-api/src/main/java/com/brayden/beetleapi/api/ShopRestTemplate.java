package com.brayden.beetleapi.api;

import com.brayden.beetleapi.domain.ShopBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Brayden
 * @create: 2019-10-25 13:56
 * 通过RestTemplate调用接口，实现负载均衡
 */
@RestController
@RequestMapping("/shopRibbon")
public class ShopRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/v1/shop/list")
    public String getShopList() {
        //get requst
        //one request style
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://beetle-server/shop/getShopList", String.class);
        System.out.println("forEntity result"+forEntity);
        //two request style
        Map<String, String> params = new HashMap<>();
        params.put("shopId","004");
        ResponseEntity<String> forEntity1 = restTemplate.getForEntity("http://beetle-server/shop/findShop/{shopId}", String.class, params);
        System.out.println("forEntity1 result"+forEntity1);
        //three reqeust style
        UriComponents UriComponents = UriComponentsBuilder.fromUriString("http://beetle-server/shop/findShop/{shopId}").build().expand("OO03").encode();
        URI uri = UriComponents.toUri();
        ResponseEntity<String> forEntity2 = restTemplate.getForEntity(uri, String.class);
        System.out.println("forEntity2 result"+forEntity2);
        //four request style
        String forObject = restTemplate.getForObject("http://beetle-server/shop/getShopList", String.class);
        System.out.println("forObject result:"+forObject);

        //post request 基本跟上面类似

        ShopBean shopBean = new ShopBean("一城一花", "Brayden raod");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://beetle-server/shop/saveShop", shopBean, String.class);
        System.out.println("post responseEntity result:"+responseEntity);
        return forEntity1.getBody();
    }



}
