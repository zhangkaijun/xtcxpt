package com.bz.xtcx.manager.entity;

import java.io.Serializable;
import java.util.List;

import com.bz.xtcx.manager.comom.BasicEntity;

/**
 * @author zhangkj
 *
 */
public class SysUser extends BasicEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3663121001443304224L;
	private String userName;
	private String password;
	private String email;
	private String cellphone;
	private String token;
	private List<SysRole> roles;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
