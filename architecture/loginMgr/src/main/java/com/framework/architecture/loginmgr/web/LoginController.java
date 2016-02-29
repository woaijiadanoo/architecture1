package com.framework.architecture.loginmgr.web;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.architecture.customerMgr.service.ICustomerService;
import com.framework.architecture.customerMgr.vo.CustomerModel;
import com.framework.architecture.loginmgr.web.vo.LoginWebModel;

@Controller
@Transactional
@RequestMapping(value="/")
public class LoginController {

	@Autowired
	private ICustomerService ics = null;

	public ICustomerService getIcs() {
		return ics;
	}

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String toLogin(){
		
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute("lwm")LoginWebModel lwm
							,HttpServletResponse response){
		
		CustomerModel cm = ics.getCusomerByID(lwm.getCustomerId());
		if(cm == null){
			return "login";
		}
		
		Cookie c = new Cookie("myCookie",cm.getUuid()+","+System.currentTimeMillis());
		response.addCookie(c);
		
		return "redirect:/toIndex";
	}
	
}
