package com.wwx.myo2o.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Shop {
	private Long areaId;
	private Long shopId;
	private Long ownerId;
	private Long shopCategoryId;
	private Long parentCategoryId;
	private String shopName;
	private String shopDesc;
	private String shopAddr;
	private String phone;
	private String shopImg;
	private Double longitude;
	private Double latitude;
	private Integer priority;
	@JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	@JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date lastEditTime;
	private Integer enableStatus;
	private String advice;

	//private List<ShopAuthMap> staffList;
	private Area area;

	private ShopCategory shopCategory;

	private ShopCategory parentCategory;
}
