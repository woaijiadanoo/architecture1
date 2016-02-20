package com.framework.architecture.customerMgr.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.architecture.customerMgr.service.ICustomerService;
import com.framework.architecture.customerMgr.vo.CustomerModel;
import com.framework.architecture.pageutil.Page;

@Controller
@Transactional
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private ICustomerService ics = null;

	public ICustomerService getIcs() {
		return ics;
	}

	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd() {

		return "/customerMgr/addCustomer";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addCustomer(HttpRequest request,CustomerModel cm) {

		ics.insertModel(cm);
		
		return "/customerMgr/success";
	}

	@RequestMapping(value="/toUpdate",method=RequestMethod.GET)
	public String toUpdate() {

		return "/customerMgr/updateCustomer";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateCustomer(HttpRequest request,CustomerModel cm) {
		ics.updateModel(cm);
		return "/customerMgr/success";
	}

	
	@RequestMapping(value="/remove/{customerUuid}",method=RequestMethod.POST)
	public String removeCustomer() {

		return "/customerMgr/success";
	}

	@RequestMapping(value="/toQuery",method=RequestMethod.GET)
	public String toQuery() {

		return "/customerMgr/queryCustomers";
	}
	
	
	public Page<CustomerModel> queryUser(){
		Page<CustomerModel> page = null;
		
		return page;
	}
}
