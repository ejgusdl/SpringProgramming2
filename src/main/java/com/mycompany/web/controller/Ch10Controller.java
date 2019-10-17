package com.mycompany.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.web.dto.Ch10Member;

@Controller
@RequestMapping("/ch10")
public class Ch10Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);
	
	//@Autowired
	@Resource(name="dataSource")
	private DataSource dataSource;
	
	@RequestMapping("/content")
	public String content() {
		return "ch10/content";
	}
	
	@RequestMapping("/connTest")
	public void connTest(HttpServletResponse response) {
		boolean result = false;
		
		try {
			//커넥션 풀에서 연결된 커넥션 대여
			Connection conn = dataSource.getConnection();
			if(conn != null) result = true;
			
			//커넥션 풀로 컨넥션을 반납
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", result);
		//pw.print("{\"result\":true}");
		pw.print(jsonObject.toString());
		pw.flush();
		pw.close();
		} catch(IOException e) {}
	}
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@RequestMapping("/getMember")
	public String getMember(String mid, Model model) {
		Ch10Member member = sqlSessionTemplate.selectOne("member.selectMemberByMid", mid);
		model.addAttribute("member", member);
		return "ch10/getMember";
	}
}




