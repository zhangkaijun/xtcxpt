package com.bz.xtcx.manager.entity;

import java.util.List;

import com.bz.xtcx.manager.comom.BasicEntity;

public class SysOrg extends BasicEntity{

	private String orgName;
	private int orgType;//组织类别
	private int sortOrder;
	private String remark;
	private String parentId;
	private List<SysOrg> orgs;
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List<SysOrg> getOrgs() {
		return orgs;
	}
	public void setOrgs(List<SysOrg> orgs) {
		this.orgs = orgs;
	}
	public int getOrgType() {
		return orgType;
	}
	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}
	
	
}
