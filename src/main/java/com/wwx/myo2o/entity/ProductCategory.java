package com.wwx.myo2o.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductCategory {
	private Long productCategoryId;
	private Long shopId;
	private String productCategoryName;
	private String productCategoryDesc;
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;

	public String toString() {
		return "[productCategoryId=" + productCategoryId
				+ ", productCategoryIdName=" + productCategoryName + "]";
	}

}
