package com.mycompany.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.web.dao.Ch30BoardDao;
import com.mycompany.web.dto.Ch30Board;

@Service
public class Ch30Service {

	@Autowired
	private Ch30BoardDao boardDao;
	
	public List<Ch30Board> getBoardList(int startRowNo, int endRowNo) {
		List<Ch30Board> boardList = boardDao.SelectList(startRowNo, endRowNo);
		return boardList;
	}

	public int getTotalRowNo() {
		int totalRowNum = boardDao.selectTotalRowNo();
		return totalRowNum;
	}
	
}
