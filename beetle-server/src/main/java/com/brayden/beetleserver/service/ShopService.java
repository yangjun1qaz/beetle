package com.brayden.beetleserver.service;

import com.brayden.beetleserver.domain.ShopBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Brayden
 * @create: 2019-10-18 10:48
 */
public interface ShopService {

     /**
      * 查询商品列表
      * @return
      */
     List<ShopBean> getShopList();

     /**
      *保存商品
      */
     public String saveShop(ShopBean shopBean);

     /**
      * feign post test
      * @param requestBody
      * @return
      */
     String postTest(String requestBody);
}
