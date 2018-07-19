package com.bz.xtcx.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

import com.bz.xtcx.manager.entity.SysOrg;

public interface SysOrgMapper {

	@Insert("insert into `sys_org`(org_id, org_name, org_type, parent_id, sort_order, remark, status, creater)"
		    + " VALUES(#{id, jdbcType=VARCHAR},"
		    + " #{orgName, jdbcType=VARCHAR},"
		    + " #{orgType, jdbcType=VARCHAR},"
		    + " #{parentId, jdbcType=VARCHAR},"
		    + " #{sortOrder, jdbcType=INTEGER},"
		    + " #{remark, jdbcType=VARCHAR},"
		    + " #{status, jdbcType=INTEGER},"
		    + " #{creater, jdbcType=VARCHAR})"
		    )
    @SelectKey(before = true, keyProperty = "id", resultType = String.class, statementType = StatementType.STATEMENT, statement="select uuid()")
	int insert(SysOrg sysOrg);
	
	@Select("select * from `sys_org`")
    @Results(id = "sysOrg", 
		value = { 
		    @Result(id = true, property = "id", column = "org_id"),
		    @Result(property = "orgName", column = "org_name"),
		    @Result(property = "orgType", column = "org_type"),
		    @Result(property = "parentId", column = "parent_id"),
		    @Result(property = "sortOrder", column = "sort_order"),
		    @Result(property = "remark", column = "remark"),
		    @Result(property = "status", column = "status"),
		    @Result(property = "createTime", column = "create_time"),
		    @Result(property = "creater", column = "creater"),
		    @Result(property = "updateTime", column = "update_time"),
		    @Result(property = "updater", column = "updater")
		}
    )
	List<SysOrg> findAll();
}
