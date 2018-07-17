package com.bz.xtcx.manager.service;

import java.util.List;

import com.bz.xtcx.manager.entity.Userinfo;

public interface IUserService {

	public List<Userinfo> getUserByEmail(String email);
	
	public void save(Userinfo user);
}
