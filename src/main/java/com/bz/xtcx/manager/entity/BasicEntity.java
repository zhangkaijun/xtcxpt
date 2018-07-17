package com.bz.xtcx.manager.entity;

import java.io.Serializable;
import java.sql.Date;

import com.bz.xtcx.manager.enums.StatusEnum;

public class BasicEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7049926191910997900L;
	
	private String id;
	private Date createTime;
	private String creater = "auto";
	private String updater;
	private Date updateTime;
	private Integer status = StatusEnum.Enable.value();
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
