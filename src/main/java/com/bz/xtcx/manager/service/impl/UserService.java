package com.bz.xtcx.manager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bz.xtcx.manager.entity.Userinfo;
import com.bz.xtcx.manager.service.IUserService;

@Service
public class UserService implements IUserService{

	
	
	@Override
	public List<Userinfo> getUserByEmail(String email) {
		
		return null;
	}

	@Override
	public void save(Userinfo user) {
		// TODO Auto-generated method stub
		
	}

}
