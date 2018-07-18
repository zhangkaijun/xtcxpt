package com.bz.xtcx.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.bz.xtcx.manager.entity.SysUser;

public class BaseController {

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
	
	private HttpSession getSession(HttpServletRequest request){
		String token = request.getHeader("token");
		//HttpSession session = null;
		if(token != null) {
			//session = UserController.sessionMap.get(token);
		}
		return session;
	}
	
	public String getUserName(){
		String username = "auto";
		session = getSession(request);
		Object obj = session.getAttribute("");
		if(obj != null){
			username = ((SysUser)obj).getUserName();
		}
		return username;
	}
	
	public String getUserId(){
		session = getSession(request);
		Object obj = session.getAttribute("");
		String userId = null;
		//userId = "64365789BCA1ECF1E05013AC0688161E";
		if(obj != null){
			userId = ((SysUser)obj).getId();
		}
		return userId;
	}
}
