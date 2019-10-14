package com.mycompany.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.web.service.Ch09Service;

@Component("ch09Dao3") //이게 붙어 있으면 스프링은 관리객체로 인식
public class Ch09Dao3 {
	private static final Logger logger =
			LoggerFactory.getLogger(Ch09Dao3.class);
	
	public Ch09Dao3() {
		logger.debug("실행");
	}
	
	public void insert() {
		logger.debug("실행");
	}
}
