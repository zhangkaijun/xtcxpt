package com.bz.xtcx.mamager.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.xtcx.manager.SampleWarApplication;
import com.bz.xtcx.manager.entity.SysOrg;
import com.bz.xtcx.manager.mapper.SysOrgMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleWarApplication.class)
public class SysOrgMapperTest {

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Test
	public void insert() {
		SysOrg org = new SysOrg();
		org.setOrgName("省级机构");
		int result = sysOrgMapper.insert(org);
		System.out.println(result);
		
	}
}
