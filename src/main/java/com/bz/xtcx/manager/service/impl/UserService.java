package com.bz.xtcx.manager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.service.IUserService;

@Service
public class UserService implements IUserService{

	
	
	@Override
	public List<SysUser> getUserByEmail(String email) {
		
		return null;
	}

	@Override
	public void save(SysUser user) {
		// TODO Auto-generated method stub
		
	}

}
