package com.bz.xtcx.manager.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.bz.xtcx.manager.entity.SysUser;


public class BaseService {
	
	@Resource
    private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * 创建redis缓存session
	 * @param username
	 * @param session
	 */
	public void createRedisUser(String username, SysUser user) {
		if(redisTemplate.opsForValue().getOperations().hasKey(username)) {
			String token = redisTemplate.opsForValue().get(username).toString();
			boolean result = redisTemplate.delete(username);
			System.out.println(result);
			result = redisTemplate.delete(token);
			System.out.println(result);
		}
		redisTemplate.opsForValue().set(username, session.getId());
		redisTemplate.opsForValue().set(session.getId(), user);
	}
	
	public String getUserName(){
		String username = "auto";
		String token = request.getHeader("token");
		if(token == null) {
			return username;
		}
		Object obj = redisTemplate.opsForValue().get(token);
		if(obj != null){
			username = ((SysUser)obj).getUserName();
		}
		return username;
	}
	
	public String getUserId(){
		String userId = null;
		String token = request.getHeader("token");
		if(token == null) {
			return userId;
		}
		Object obj = redisTemplate.opsForValue().get(token);
		if(obj != null){
			userId = ((SysUser)obj).getId();
		}
		return userId;
	}

	
}
