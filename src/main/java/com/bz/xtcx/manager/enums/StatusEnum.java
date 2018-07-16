package com.bz.xtcx.manager.enums;

/**
 * @author zhangkj
 *
 */
public enum StatusEnum {

	Enable(1, "正常"),
	Disable(0, "禁用");
	
	private final int value;

    private final String theName;
    
    public int value() {
        return this.value;
    }

    public String theName() {
        return this.theName;
    }
    
	StatusEnum(int value, String theName) {
        this.value = value;
        this.theName = theName;
    }
}
