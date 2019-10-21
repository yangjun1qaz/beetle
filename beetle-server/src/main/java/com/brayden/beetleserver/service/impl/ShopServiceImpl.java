package com.brayden.beetleserver.service.impl;

import com.brayden.beetleserver.domain.ShopBean;
import com.brayden.beetleserver.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: Brayden
 * @create: 2019-10-18 10:51
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Override
    public List<ShopBean> getShopList() {
        ArrayList<ShopBean> shopList = new ArrayList<>();
        shopList.add(new ShopBean("烟酒", "敬业一路")) ;
        shopList.add(new ShopBean("便利店", "天水路")) ;
        return shopList;
    }
}
