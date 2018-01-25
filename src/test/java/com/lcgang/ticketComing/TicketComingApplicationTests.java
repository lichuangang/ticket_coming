package com.lcgang.ticketComing;

import com.lcgang.ticketComing.servicie.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.lcgang.ticketComing.mapper")
public class TicketComingApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		userService.test();
	}

	@Test
	public void test2() {
//		SetLocationParam param=new SetLocationParam();
//		param.setOpenId("test1");
//		param.setLatitude(123);
//		param.setLongitude(456);
//		userService.setUserLocation(param);
	}

}
