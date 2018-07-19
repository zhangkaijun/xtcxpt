package com.bz.xtcx.manager.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.service.IEmailService;
import com.bz.xtcx.manager.service.ISysUserService;
import com.bz.xtcx.manager.vo.VoResponse;
import com.bz.xtcx.manager.vo.VoUser;

@RestController
@RequestMapping("xtcx/user")
public class LoginController extends BaseController{
	
	@Autowired
	private ISysUserService sysUserService;
	
	@Autowired
	private IEmailService emailService;

	@GetMapping
	public Object hello() {
		String msg = "Hello,LoginController";
		return msg;
	}
	
	@PostMapping("login")
	public Object login(@RequestBody VoUser vo) {
		VoResponse voRes = getVoResponse();
		if(StringUtils.isEmpty(vo.getUsername()) || StringUtils.isEmpty(vo.getPassword())) return null;
		if(vo.isAdmin()) {
			voRes = sysUserService.signIn(vo.getUsername(), vo.getPassword());
		}else {
			
		}
		return voRes;
	}
	
	@PostMapping("logout")
	public Object logout(){
		VoResponse voRes = new VoResponse();
		sysUserService.signOut();
		return voRes;
	}

	@PostMapping("register")
	public Object register(SysUser user) {
		VoResponse voRes = getVoResponse();
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
		if(sysUserService.getUserByEmail(user.getEmail()).size() > 0) {
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
		/*HttpSession session = getSession();
		session.setAttribute(user.getEmail(), uuid);
		session.setMaxInactiveInterval(5 * 60 * 1000);*/
		//sysUserService.save(user);
		return voRes;
	}
	
	
	
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		//对密码进行 md5 加密
		String password = "123456";
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(md5Password);
	}
	
}
