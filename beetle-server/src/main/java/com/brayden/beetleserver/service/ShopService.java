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

     List<ShopBean> getShopList();

     String postTest(String requestBody);
}
