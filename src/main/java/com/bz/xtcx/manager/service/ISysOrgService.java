package com.bz.xtcx.manager.service;

import java.util.List;

import com.bz.xtcx.manager.entity.SysOrg;
import com.bz.xtcx.manager.vo.VoResponse;

public interface ISysOrgService {

	List<SysOrg> getAll();
	
	VoResponse saveOrUpdate(SysOrg org);
	
	
}
