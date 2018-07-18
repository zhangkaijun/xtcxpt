/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bz.xtcx.manager.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.service.IEmailService;
import com.bz.xtcx.manager.service.IUserService;
import com.bz.xtcx.manager.vo.VoResponse;

@RestController
@RequestMapping("xtcx/login")
public class LoginController extends BaseController{
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IEmailService emailService;

	@GetMapping
	public Object hello() {
		String msg = "Hello,LoginController";
		return msg;
	}

	@PostMapping("register")
	public Object register(SysUser user) {
		VoResponse voRes = new VoResponse();
		if(StringUtils.isEmpty(user.getUserName())) {
			voRes.setNull(voRes);
			voRes.setMessage("用户名不能为空");
			return voRes;
		}
		if(StringUtils.isEmpty(user.getEmail())) {
			voRes.setNull(voRes);
			voRes.setMessage("邮箱地址不能为空");
			return voRes;
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			voRes.setNull(voRes);
			voRes.setMessage("密码不能为空");
			return voRes;
		}
		//检查邮箱是否已经注册
		if(userService.getUserByEmail(user.getEmail()).size() > 0) {
			voRes.setFail(voRes);
			voRes.setMessage("邮箱已经被注册");
			return voRes;
		}
		
		boolean result = false;
		UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        result = emailService.sendRegisterEmail(user.getEmail(), uuid.toString());
		if(!result) {
			voRes.setFail(voRes);
			voRes.setMessage("邮箱验证有误，请重新输入邮箱");
			return voRes;
		}
		HttpSession session = getSession();
		session.setAttribute(user.getEmail(), uuid);
		session.setMaxInactiveInterval(5 * 60 * 1000);
		userService.save(user);
		return voRes;
	}
	
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
	}
	
}
