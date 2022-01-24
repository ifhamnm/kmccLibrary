package com.kmcc.library.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmcc.library.common.Constants;

@Service
public class HomeService {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BookService bookService;
	
	public Map<String, Long> getTopTilesMap() {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("totalMembers", memberService.getTotalCount());
		map.put("totalStudents", memberService.getStudentsCount());
		map.put("totalStaffs", memberService.getStaffsCount());
		map.put("totalCategories", categoryService.getTotalCount());
		map.put("totalBooks", bookService.getTotalCount());
		map.put("totalIssuedBooks", bookService.getTotalIssuedBooks());
		return map;
	}
	
}
