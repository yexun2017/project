package com.wwx.myo2o.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ShopCategory {
	private Long shopCategoryId;
	private Long parentId;
	private String shopCategoryName;
	private String shopCategoryDesc;
	private String shopCategoryImg;
	private Integer priority;
	@JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	@JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date lastEditTime;
	private ShopCategory parent;
}