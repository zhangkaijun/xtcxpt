package com.bz.xtcx.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;

import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.mapper.provider.SysUserProvider;

public interface SysUserMapper {
	
	@Insert("insert into `sys_user`(user_id, user_name, password, cellphone, email, status, creater)"
		    + " VALUES(#{id, jdbcType=VARCHAR},"
		    + " #{userName, jdbcType=VARCHAR},"
		    + " #{password, jdbcType=VARCHAR},"
		    + " #{cellphone, jdbcType=VARCHAR},"
		    + " #{email, jdbcType=INTEGER},"
		    + " #{status, jdbcType=INTEGER},"
		    + " #{creater, jdbcType=VARCHAR})"
		    )
    @SelectKey(before = true, keyProperty = "id", resultType = String.class, statementType = StatementType.STATEMENT, statement="select uuid()")
	int insert(SysUser user);

	@SelectProvider(type = SysUserProvider.class, method = "findCount")
    int findCount(SysUser user);
	
	@SelectProvider(type = SysUserProvider.class, method = "findByCondition")
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
    List<SysUser> findByCondition(SysUser user);
	
	@Select("select * from `sys_user` where user_name = #{username} or email = #{username}")
    @ResultMap("sysUser")
	SysUser findByUserameOrEmail(String username);
	
	
}
