package com.bz.xtcx.manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("xtcx")
public class MyController {

	@GetMapping
	public Object hello() {
		String msg = "Hello,协同创新平台";
		return msg;
	}

}
