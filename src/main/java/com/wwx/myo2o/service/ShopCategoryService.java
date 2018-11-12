package com.wwx.myo2o.service;

import com.wwx.myo2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    List<ShopCategory> queryShopCategoryListInfo(ShopCategory shopCategory);
}
