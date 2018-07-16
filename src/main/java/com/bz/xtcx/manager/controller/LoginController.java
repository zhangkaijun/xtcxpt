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

import org.apache.cxf.common.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bz.xtcx.manager.entity.Userinfo;

@RestController
@RequestMapping("xtcx/login")
public class LoginController {

	@GetMapping
	public Object hello() {
		String msg = "Hello,LoginController";
		return msg;
	}

	@PostMapping("register")
	public Object register(Userinfo user) {
		if(StringUtils.isEmpty(user.getEmail())) {
			
		}
		return null;
	}
}
