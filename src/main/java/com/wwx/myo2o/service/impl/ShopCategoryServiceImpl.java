package com.wwx.myo2o.service.impl;

import com.wwx.myo2o.entity.ShopCategory;
import com.wwx.myo2o.mapper.ShopCategoryMapper;
import com.wwx.myo2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/10/29  9:00
 **/
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Override
    public List<ShopCategory> queryShopCategoryListInfo(ShopCategory shopCategory) {
        return shopCategoryMapper.queryShopCategory(shopCategory);
    }
}
