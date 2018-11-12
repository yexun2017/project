package com.wwx.myo2o.mapper;


import com.wwx.myo2o.entity.ProductImg;

import java.util.List;

public interface ProductImgMapper {

	List<ProductImg> queryProductImgList(long productId);

	int batchInsertProductImg(List<ProductImg> productImgList);

	int deleteProductImgByProductId(long productId);
}
