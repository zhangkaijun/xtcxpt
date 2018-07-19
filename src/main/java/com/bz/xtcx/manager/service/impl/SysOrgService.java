package com.bz.xtcx.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bz.xtcx.manager.entity.SysOrg;
import com.bz.xtcx.manager.mapper.SysOrgMapper;
import com.bz.xtcx.manager.service.ISysOrgService;
import com.bz.xtcx.manager.vo.VoResponse;

@Service
public class SysOrgService implements ISysOrgService {

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Override
	public List<SysOrg> getAll() {
		List<SysOrg> list = sysOrgMapper.findAll();
		return list;
	}

	@Override
	public VoResponse saveOrUpdate(SysOrg org) {
		if(StringUtils.isEmpty(org.getId())) {//add
			
			
		}else {//update
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		String s = "";
		System.out.println(StringUtils.isEmpty(s));
	}

}
