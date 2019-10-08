package com.mycompany.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	
	@RequestMapping("/content")
	public String content() {
		return "ch06/content";
	}
	
	@PostMapping("/login")
	public String lofin(String mid, String mpassword, HttpSession session) {
		String loginResult = "";
		if(mid.equals("admin")) {
			if(mpassword.equals("iot12345")) {
				loginResult = "success";
			} else {
				loginResult = "wrongMpassword";
			}
		} else {
			loginResult = "wrongMid";
		}
		
		session.setAttribute("loginResult", loginResult);
		
		return "redirect:/ch06/content";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginResult");
		return "redirect:/ch06/content";
	}
	
}
