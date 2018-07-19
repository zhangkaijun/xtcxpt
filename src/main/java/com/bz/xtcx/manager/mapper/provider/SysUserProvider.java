package com.bz.xtcx.manager.mapper.provider;

import com.bz.xtcx.manager.entity.SysUser;

public class SysUserProvider {

	public String findCount(SysUser user){
        StringBuilder sql = new StringBuilder("select count(*) from `sys_user` where 1=1");
        sql.append(queryCondition(user));
        return sql.toString();
    }
	
	public String findByCondition(SysUser user) {
		StringBuilder sql = new StringBuilder("select * from `sys_user` where 1=1");
		sql.append(queryCondition(user));
        return sql.toString();
	}
	
	StringBuilder queryCondition(SysUser user) {
		StringBuilder sql = new StringBuilder();
		if (user.getUserName() != null)
            sql.append(" and user_name='"+user.getUserName()+"'");
        if (user.getCellphone() != null)
            sql.append(" and cellphone='"+user.getCellphone()+"'");
		return sql;
	}
}
