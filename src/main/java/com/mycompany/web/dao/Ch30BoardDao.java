package com.mycompany.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.web.dto.Ch30Board;

@Component
public class Ch30BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 
	
	public List<Ch30Board> SelectList(int startRowNo, int endRowNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("startRowNo", startRowNo);
		map.put("endRowNo", endRowNo);
		List<Ch30Board> boardList = sqlSessionTemplate.selectList("board.selectList", map);		
		return boardList;
	}

	public int selectTotalRowNo() {
		int totalRowNum = sqlSessionTemplate.selectOne("board.selectTotalRowNum");
		return totalRowNum;
	}
	
	
}
