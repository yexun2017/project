package com.wwx.myo2o.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Area {
	private Long areaId;
	private String areaName;
	private String areaDesc;
	private Integer priority;
	@JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	@JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date lastEditTime;
}
