package com.bz.xtcx.manager.service;

import java.util.List;

import com.bz.xtcx.manager.entity.SysUser;

public interface IUserService {

	public List<SysUser> getUserByEmail(String email);
	
	public void save(SysUser user);
}
