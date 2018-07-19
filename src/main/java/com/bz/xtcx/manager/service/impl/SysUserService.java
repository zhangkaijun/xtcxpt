package com.bz.xtcx.manager.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.mapper.SysUserMapper;
import com.bz.xtcx.manager.service.ISysUserService;
import com.bz.xtcx.manager.vo.VoResponse;

@Service
public class SysUserService extends BaseService implements ISysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public List<SysUser> getUserByEmail(String email) {
		return null;
	}

	@Override
	public VoResponse saveOrUpdate(SysUser user) {
		VoResponse voRes = new VoResponse();
		if(user.getId() == null) {//add
			SysUser query = new SysUser();
			query.setUserName(user.getUserName());
			List<SysUser> list = sysUserMapper.findByCondition(query);
			if(list != null && list.size() > 0) {
				voRes.setFail(voRes);
				voRes.setMessage("用户名已经存在");
				return voRes;
			}
			String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());//md5加密
			user.setPassword(md5Password);
			user.setCreater(this.getUserName());
			user.setStatus(1);
			sysUserMapper.insert(user);
		}
		return voRes;
		
	}
	
	@Override
	public VoResponse signIn(String username, String password) {
		VoResponse voRes = new VoResponse();
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());//md5加密
		SysUser user = this.getUserByUsername(username);
		if(user != null && user.getPassword().equals(md5Password)) {
			HttpSession session = getSession();
			user.setToken(session.getId());
			this.createRedisUser(username, user);
			voRes.setData(user);
			return voRes;
		}
		voRes.setFail(voRes);
		voRes.setMessage("用户名或者密码错误");
		return voRes;
	}
	
	@Override
	public void signOut() {
		this.destroyedRedisUser();
	}

	@Override
	public SysUser getUserByUsername(String username) {
		SysUser user = sysUserMapper.findByUserameOrEmail(username);
		return user;
	}

	
	
	

}
