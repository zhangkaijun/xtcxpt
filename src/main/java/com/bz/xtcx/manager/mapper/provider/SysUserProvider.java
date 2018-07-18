package com.bz.xtcx.manager.mapper.provider;

import com.bz.xtcx.manager.entity.SysUser;

public class SysUserProvider {

	public String findCount(SysUser sysUser){
        StringBuilder sql = new StringBuilder("select count(*) from `sys_user` where 1=1");
        sql.append(queryCondition(sysUser));
        return sql.toString();
    }
	
	public String findEntityByPage(SysUser sysUser) {
		StringBuilder sql = new StringBuilder("select * from `sys_user` where 1=1");
		sql.append(queryCondition(sysUser));
        return sql.toString();
	}
	
	StringBuilder queryCondition(SysUser sysUser) {
		StringBuilder sql = new StringBuilder();
		if (sysUser.getUserName() != null)
            sql.append(" and user_name='"+sysUser.getUserName()+"'");
        if (sysUser.getCellphone() != null)
            sql.append(" and cellphone='"+sysUser.getCellphone()+"'");
		return sql;
	}
}
