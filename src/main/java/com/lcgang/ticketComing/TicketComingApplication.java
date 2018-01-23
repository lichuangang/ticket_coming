package com.lcgang.ticketComing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lcgang.ticketComing.mapper")
public class TicketComingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketComingApplication.class, args);
	}
}
