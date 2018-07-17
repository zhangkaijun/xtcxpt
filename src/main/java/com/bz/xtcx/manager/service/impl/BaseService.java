package com.bz.xtcx.manager.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.bz.xtcx.manager.entity.Userinfo;


public class BaseService {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;

	
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
			username = ((Userinfo)obj).getUsername();
		}
		return username;
	}
	
	public String getUserId(){
		session = getSession(request);
		Object obj = session.getAttribute("");
		String userId = null;
		//userId = "64365789BCA1ECF1E05013AC0688161E";
		if(obj != null){
			userId = ((Userinfo)obj).getId();
		}
		return userId;
	}

	
}
