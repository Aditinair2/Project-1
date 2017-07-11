package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	/*
	 * This controller is to load login page and show login related errors
	 */


	@RequestMapping("/loginPage")
	public String loadLoginPage() {
		return "customerLogin";
	}

	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		//System.out.println("Inside login mapping");
		//System.out.println(logout+"    "+error);
		
		if (error != null) {
			model.addAttribute("error", "Invalid username and password");
			return "customerLogin";// return to login page
		}
		
		else if(logout!=null)
			return "redirect:/";//After successfull logout
	
		return "customerLogin";// return to login page
		}
}
