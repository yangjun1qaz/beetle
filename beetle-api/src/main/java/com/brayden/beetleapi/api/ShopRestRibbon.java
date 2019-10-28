package com.brayden.beetleapi.api;

import com.brayden.beetleapi.domain.ShopBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
 * 通过ribbon实现负载均衡；
 * 官网给出三种调用方式，目前是实现了两种；
 * 第三种继承官方接口，customizing rule 等；
 */
@RestController
@RequestMapping("/shopRibbon")
public class ShopRestRibbon {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/v1/shop/list")
    public String getShopList() {
        //one execute style
        //get requst
        //one request style
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://beetle-server/shop/getShopList", String.class);
        System.out.println("forEntity result" + forEntity);
        //two request style
        Map<String, String> params = new HashMap<>();
        params.put("shopId", "004");
        ResponseEntity<String> forEntity1 = restTemplate.getForEntity("http://beetle-server/shop/findShop/{shopId}", String.class, params);
        System.out.println("forEntity1 result" + forEntity1);
        //three reqeust style
        UriComponents UriComponents = UriComponentsBuilder.fromUriString("http://beetle-server/shop/findShop/{shopId}").build().expand("OO03").encode();
        URI uri = UriComponents.toUri();
        ResponseEntity<String> forEntity2 = restTemplate.getForEntity(uri, String.class);
        System.out.println("forEntity2 result" + forEntity2);
        //four request style
        String forObject = restTemplate.getForObject("http://beetle-server/shop/getShopList", String.class);
        System.out.println("forObject result:" + forObject);

        //post request 基本跟上面类似

        ShopBean shopBean = new ShopBean("一城一花", "Brayden raod");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://beetle-server/shop/saveShop", shopBean, String.class);
        System.out.println("post responseEntity result:" + responseEntity);
        return forEntity1.getBody();
    }

    @GetMapping("/v2/shop/list")
    public String getShopListv2() {
//        two execute style,this is style cancal down configured
//        @Bean
//        @LoadBalanced
//        public RestTemplate restTemplate() {
//            return new RestTemplate();
//        }
        ServiceInstance instance = loadBalancerClient.choose("beetle-server");
        URI url = URI.create(String.format("https://%s:%s", instance.getHost(), instance.getPort()));
        ShopBean shopBean = new ShopBean("一城一花", "Brayden raod");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, shopBean, String.class);
        System.out.println("post responseEntity result:" + responseEntity);
        return responseEntity.getBody();
    }


}
