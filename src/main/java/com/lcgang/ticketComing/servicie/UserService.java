package com.lcgang.ticketComing.servicie;

import com.lcgang.framework.dto.wx.Coordinate;
import com.lcgang.ticketComing.dtos.auth.SetLocationParam;

public interface UserService {
	
	public void test();
	
	public void setUserLocation(SetLocationParam param);
	
	public Coordinate getCoordinate(String openId);

}
