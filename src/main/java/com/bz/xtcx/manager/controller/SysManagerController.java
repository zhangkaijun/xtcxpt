package com.bz.xtcx.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bz.xtcx.manager.entity.SysOrg;
import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.service.ISysOrgService;
import com.bz.xtcx.manager.service.ISysUserService;
import com.bz.xtcx.manager.vo.VoResponse;


@RestController
@RequestMapping("xtcx/sysManager")
public class SysManagerController extends BaseController{

	@Autowired
	private ISysOrgService sysOrgService;
	
	@Autowired
	private ISysUserService sysUserService;
	
	@PostMapping("user")
	public Object addSysUser(@RequestBody SysUser user) {
		VoResponse voRes = getVoResponse();
		if(StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) return voRes;
		voRes = sysUserService.saveOrUpdate(user);
		return voRes;
	}
	
	@GetMapping("org/getAll")
	public Object getAllOrgs() {
		VoResponse voRes = getVoResponse();
		return voRes;
	}
	
	@DeleteMapping
	public Object del(@RequestParam("id") String id) {
		VoResponse voRes = getVoResponse();
		return voRes;
	}
	
	@PostMapping
	public Object add(@RequestBody SysOrg org) {
		VoResponse voRes = getVoResponse();
		return voRes;
	}
	
	@PutMapping
	public Object update(@RequestBody SysOrg org) {
		VoResponse voRes = getVoResponse();
		return voRes;
	}
	

}
