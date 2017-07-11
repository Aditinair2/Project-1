package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller
public class HomeController {
	@Autowired
	CategoryDao cat;
	

	@RequestMapping("/")
	public String getpage(Model model)
	{
		System.out.println("inside method getpage");
		List<Category> categoryRecordss=cat.list();
		model.addAttribute("categoryList",categoryRecordss);
		return"index";
	}
	@RequestMapping("/aboutusPage")
    public String getaboutuspage()
	{
		System.out.println("inside aboutus page");
        return "aboutus";
    }
	
}
