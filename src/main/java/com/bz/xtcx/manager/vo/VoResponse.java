package com.bz.xtcx.manager.vo;

public class VoResponse {
	
	private Integer code;
	private Boolean success;
	private String message;
	private Object data;
	
	public VoResponse() {
		this.setCode(10000);
		this.setSuccess(Boolean.TRUE);
	}
	
	public VoResponse(Integer code, Boolean success) {
		super();
		this.code = code;
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public void setNull(VoResponse voRes){
		voRes.setCode(10001);
		voRes.setSuccess(false);
	}
	public void setFail(VoResponse voRes){
		voRes.setCode(10002);
		voRes.setSuccess(false);
	}
	public void setSuccess(VoResponse voRes){
		voRes.setCode(10000);
		voRes.setSuccess(true);
	}
}
