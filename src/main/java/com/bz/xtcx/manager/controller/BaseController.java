package com.bz.xtcx.manager.controller;

import com.bz.xtcx.manager.vo.VoResponse;

public class BaseController {
	
	public VoResponse getVoResponse(){
		VoResponse voRes = new VoResponse(10001, false);
		return voRes;
	}
}
