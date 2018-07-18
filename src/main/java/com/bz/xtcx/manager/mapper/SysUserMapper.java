package com.bz.xtcx.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.mapper.provider.SysUserProvider;

public interface SysUserMapper {

	@SelectProvider(type = SysUserProvider.class, method = "findCount")
    int findCount(SysUser sysUser);
	
	@SelectProvider(type = SysUserProvider.class, method = "findEntityByPage")
	@Results(
		id = "sysUser",
		value = {
		    @Result(id = true, property = "id", column = "user_id"),
		    @Result(property = "userName", column = "user_name"),
		    @Result(property = "password", column = "password"),
		    @Result(property = "cellphone", column = "cellphone"),
		    @Result(property = "email", column = "email"),
		    @Result(property = "status", column = "status"),
		    @Result(property = "creater", column = "creater"),
		    @Result(property = "createTime", column = "create_time"),
		    @Result(property = "updater", column = "updater"),
		    @Result(property = "updateTime", column = "update_time")
		    //@Result(property = "roles", column = "user_id", many = @Many(select = "com.elextec.mdm.mapper.RoleMapper.findRolesByUserId") ) 
	    }
	)
    List<SysUser> findByPage(SysUser sysUser);

}
