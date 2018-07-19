package com.bz.xtcx.manager.service;

import java.util.List;

import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.vo.VoResponse;

public interface ISysUserService {

	public List<SysUser> getUserByEmail(String email);
	
	/**
	 * 新增或者修改用户信息
	 * @param user
	 * @return
	 */
	public VoResponse saveOrUpdate(SysUser user);
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public VoResponse signIn(String username, String password);
	
	/**
	 * 登出
	 */
	public void signOut();
	
	/**
	 * 用户名或者邮箱查找用户信息
	 * @param username
	 * @return
	 */
	public SysUser getUserByUsername(String username);
}
