package com.mycompany.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.web.dto.Ch30Board;
import com.mycompany.web.service.Ch30Service;

@Component
@RequestMapping("/ch30")
public class Ch30Controller {
	
	@Autowired
	public Ch30Service service;
	
	@RequestMapping("/content")
	public String content() {
		return "ch30/content";
	}
	
	@RequestMapping("/boardList")
	public String boardList(Model model, @RequestParam(defaultValue="1") int pageNo) {
		
		//페이지당 행수 이것은 테스트다
		int rowsPerPage = 10;
		//이전, 다음을 클릭했을 때 나오는 페이지 수
		int pagesPerGroup =5;
		//전체 게시물 수
		int totalRowNum = service.getTotalRowNo();
		//전체 페이지 수
		int totalPageNum = totalRowNum / rowsPerPage;
		if(totalRowNum % rowsPerPage != 0) totalPageNum++;	
		//전체 그룹 수
		int totalGroupNum = totalPageNum / pagesPerGroup;
		if(totalPageNum % pagesPerGroup != 0) totalGroupNum++;
				
				
		//현재 페이지의 그룹번호
		int groupNo = (pageNo-1)/pagesPerGroup + 1;
		//현재 그룹의 시작 페이지 번호
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		//현재 그룹의 마지막 페이지 번호
		int endPageNo = startPageNo+pagesPerGroup - 1;
		if(groupNo == totalGroupNum) endPageNo = totalPageNum;
		//현재 페이지의 시작 행번호
		int startRowNo = (pageNo-1)*rowsPerPage + 1;
		//현재 페이지의 끝 행번호
		int endRowNo = pageNo*rowsPerPage;
		if(groupNo == totalGroupNum) endRowNo = totalRowNum;
				
		
		
		List<Ch30Board> boardList = service.getBoardList(startRowNo, endRowNo);
		
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("totalGroupNum", totalGroupNum);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("boardList", boardList);
		return "ch30/boardList";
	}
	
	@RequestMapping("/writeBoardForm")
	public String writeBoardForm() {
		return "ch30/writeBoardForm";
	}
	
}






