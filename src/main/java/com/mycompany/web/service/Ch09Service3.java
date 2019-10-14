package com.mycompany.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.web.dao.Ch09Dao3;

@Service
public class Ch09Service3 {
	private static final Logger logger =
			LoggerFactory.getLogger(Ch09Service3.class);
	
	@Autowired  //자동적으로 set에 객체 주입됨, 관리객체는 기본 생성자가 있다
	private Ch09Dao3 ch09Dao3;
	
	public void method3() {
		logger.debug("실행");	
		ch09Dao3.insert();
	}
}
