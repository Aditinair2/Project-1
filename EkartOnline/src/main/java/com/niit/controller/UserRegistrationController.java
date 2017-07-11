package com.niit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.UserDetailDao;
import com.niit.model.UserDetail;

import java.util.List;

import javax.validation.Valid;

/*
 * This Controller is used to Registration user into the system
 */
@Controller
public class UserRegistrationController {

	
	public UserRegistrationController() {
		System.out.println(" inside controller");
	}
	
	@Autowired
	private UserDetailDao userDetailDAO;

	/*
	 * RegistrationUserPost method is used to Registration user into the system and to
	 * show registration related errors
	 */

	
	@RequestMapping("/register")
	public String RegistrationUser(Model model) {
   System.out.println(" inside method Registration");
		UserDetail usersDetail = new UserDetail();
		model.addAttribute("usersDetail", usersDetail);
		return "CustomerRegistration";
	}
	
	
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public ModelAndView RegistrationUserPost(@Valid @ModelAttribute("usersDetail") UserDetail usersDetail,
			BindingResult result) {
		
		if (result.hasErrors()) {					
			ModelAndView model=new ModelAndView("CustomerRegistration");
			model.addObject("message", "You have entered invalid details");
			
			System.out.println("Page has errors");
			return model;
		}
		
		List<UserDetail> usersDetailList = userDetailDAO.getAllUsers();

        for (int i=0; i< usersDetailList.size(); i++) {
        	ModelAndView model=new ModelAndView("CustomerRegistration");
        	if(usersDetail.getUserEmail().equals(usersDetailList.get(i).getUserEmail())) {
                model.addObject("emailError", "Email already exists");

                return model;
            }

            if(usersDetail.getUser().getUsername().equals(usersDetailList.get(i).getUser().getUsername())) {
                model.addObject("usernameError", "Username already exists");
                return model;
            }
            if(usersDetail.getUserPhone().equals(usersDetailList.get(i).getUserPhone())) {
                model.addObject("userPhoneError", "User phone already exists");
                return model;
            }
        }
		/*if(usersDetailDAO.isValidUser(usersDetail.getUsername())==false){
			ModelAndView model=new ModelAndView("customerRegistration");
			model.addObject("usernameError", "User name already exists");
			return model;
		}*/
		
		userDetailDAO.addUser(usersDetail);
		ModelAndView model=new ModelAndView("registrationSuccess");
		return model;
	}
//}
}