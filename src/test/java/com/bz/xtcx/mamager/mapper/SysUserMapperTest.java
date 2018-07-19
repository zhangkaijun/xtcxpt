package com.bz.xtcx.mamager.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.xtcx.manager.SampleWarApplication;
import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.mapper.SysUserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleWarApplication.class)
public class SysUserMapperTest {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Test
	public void findCount() {
		SysUser user = new SysUser();
		int count = sysUserMapper.findCount(user);
		System.out.println(count);
	}
	
	@Test
	public void findByPage() {
		SysUser user = new SysUser();
		Page<SysUser> page = PageHelper.startPage(1, 3);
		List<SysUser> list = sysUserMapper.findByCondition(user);
		PageInfo<SysUser> info = new PageInfo<SysUser>(page);
		for(SysUser o : list) {
			System.out.println(o.getUserName());
		}
	}

}
