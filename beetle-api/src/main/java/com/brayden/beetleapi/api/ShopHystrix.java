package com.brayden.beetleapi.api;

import com.brayden.beetleapi.server.ShopService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Brayden
 * @create: 2019-11-01 10:03
 * 服务熔断、降级
 * 相同点：
 * 目的很一致，都是从可用性可靠性着想，为防止系统的整体缓慢甚至崩溃，采用的技术手段；
 * 最终表现类似，对于两者来说，最终让用户体验到的是某些功能暂时不可达或不可用；
 * 粒度一般都是服务级别，当然，业界也有不少更细粒度的做法，比如做到数据持久层（允许查询，不允许增删改）；
 * 自治性要求很高，熔断模式一般都是服务基于策略的自动触发，降级虽说可人工干预，但在微服务架构下，完全靠人显然不可能，开关预置、配置中心都是必要手段；
 * 区别：
 * 触发原因不太一样，服务熔断一般是某个服务（下游服务）故障引起，而服务降级一般是从整体负荷考虑；
 * 管理目标的层次不太一样，熔断其实是一个框架级的处理，每个微服务都需要（无层级之分），而降级一般需要对业务有层级之分（比如降级一般是从最外围服务开始）
 * 实现方式不太一样；服务降级具有代码侵入性(由控制器完成/或自动降级)，熔断一般称为自我熔断
 */
@RestController
@RequestMapping("/hystrix")
public class ShopHystrix {


    @Autowired
    private ShopService shopService;

    @RequestMapping("/findShop/{shopId}")
    @HystrixCommand(fallbackMethod = "findShopTest")
    public String findShop(@PathVariable("shopId") String shopId){
        String shop = shopService.findShop(shopId);
        return shop;
    }

    public String  findShopTest(String shopId){
        String result="sorry,当前系统太拥挤，你被挤出来了，请稍后在试";
        return result;
    }

}
