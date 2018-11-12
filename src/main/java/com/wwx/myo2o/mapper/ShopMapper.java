package com.wwx.myo2o.mapper;

import com.wwx.myo2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper {
	Shop queryByShopId(long shopId);
	/*@Insert("INSERT INTO tb_shop(owner_id,area_id,shop_category_id,parent_category_id,shop_name,shop_desc,shop_addr,phone,shop_img,\n" +
            "longitude,latitude,priority,create_time,last_edit_time,enable_status,advice) VALUES (#{ownerId},#{area.areaId},\n" +
            "#{shopCategory.shopCategoryId},#{parentCategory.shopCategoryId},#{shopName},#{shopDesc},#{shopAddr},#{phone},\n" +
            "#{shopImg},#{longitude},#{latitude},#{priority},#{createTime},#{lastEditTime},#{enableStatus},#{advice})")
    @Results({
            @Result(property ="area",column = "area_id",javaType = Area.class)
    })*/
	int insertShop(Shop shop);

	int updateShop(Shop shop);

	int deleteShopByName(String shopName);
}
