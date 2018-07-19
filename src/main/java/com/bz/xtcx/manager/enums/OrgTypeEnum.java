package com.bz.xtcx.manager.enums;

/**
 * @author zhangkj
 *
 */
public enum OrgTypeEnum {

	Province(1, "省级"),
	City(2, "市级"),
	Area(3, "国家高新区");
	
	private final int value;

    private final String theName;
    
    public int value() {
        return this.value;
    }

    public String theName() {
        return this.theName;
    }
    
	OrgTypeEnum(int value, String theName) {
        this.value = value;
        this.theName = theName;
    }
}
