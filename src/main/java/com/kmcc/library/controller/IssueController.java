package com.kmcc.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kmcc.library.common.Constants;
import com.kmcc.library.model.Category;
import com.kmcc.library.service.CategoryService;
import com.kmcc.library.service.IssueService;

@Controller
@RequestMapping(value = "/issue")
public class IssueController {

	@Autowired
	private IssueService issueService;
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute(name = "memberTypes")
	public List<String> memberTypes() {
		return Constants.MEMBER_TYPES;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.getAllBySort();
	}
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String listIssuePage(Model model) {
		model.addAttribute("issues", issueService.getAllUnreturned());
		return "/issue/list";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newIssuePage(Model model) { 
		return "/issue/form";
	}
	
}
