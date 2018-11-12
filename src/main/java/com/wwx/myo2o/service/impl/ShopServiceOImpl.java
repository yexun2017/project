package com.wwx.myo2o.service.impl;

import com.wwx.myo2o.common.ServerResponse;
import com.wwx.myo2o.entity.Shop;
import com.wwx.myo2o.entity.ShopCategory;
import com.wwx.myo2o.mapper.ShopCategoryMapper;
import com.wwx.myo2o.mapper.ShopMapper;
import com.wwx.myo2o.service.ShopService;
import com.wwx.myo2o.utils.FileUtil;
import com.wwx.myo2o.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.util.Date;
/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/10/27  11:11
 **/
@Service
public class ShopServiceOImpl implements ShopService {

    @Autowired
    private  ShopMapper shopMapper;

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Override
    @Transactional
    public ServerResponse save(Shop shop,CommonsMultipartFile shopImg) throws RuntimeException{
        if (shop == null) {
            return  ServerResponse.createByErrorMessage("shop请求信息为空！");
        }
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            if (shop.getShopCategory() != null) {
                Long shopCategoryId = shop.getShopCategory().getShopCategoryId();
                ShopCategory sc = new ShopCategory();
                //店铺类别信息
                sc = shopCategoryMapper.queryShopCategoryById(shopCategoryId);
                shop.setParentCategoryId(sc.getParentId());
            }
            int num=shopMapper.insertShop(shop);
            if(num<=0){
                throw  new RuntimeException("店铺创建失败！");
            }else {
                try {
                    if(shopImg!=null){
                        generateShopImg(shop,shopImg);
                        num=shopMapper.updateShop(shop);
                        if (num <= 0) {
                            throw new RuntimeException("创建图片地址失败");
                        }
                    }
                } catch (RuntimeException e) {
                    throw new RuntimeException("generateShopImg error: " + e.getMessage());
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("saveShop error: " + e.getMessage());
        }
        return ServerResponse.createBySuccess();
    }

    private void generateShopImg(Shop shop, CommonsMultipartFile shopImg) {
        String dest = FileUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }
}
