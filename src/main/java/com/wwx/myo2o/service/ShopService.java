package com.wwx.myo2o.service;

import com.wwx.myo2o.common.ServerResponse;
import com.wwx.myo2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ShopService {
    ServerResponse save(Shop shop, CommonsMultipartFile shopImg);
}
