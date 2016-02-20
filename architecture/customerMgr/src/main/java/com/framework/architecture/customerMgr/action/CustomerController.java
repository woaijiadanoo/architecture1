package com.framework.architecture.customerMgr.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.architecture.common.helpers.FormatHelper;
import com.framework.architecture.common.helpers.JsonHelper;
import com.framework.architecture.customerMgr.action.vo.CustomerWebModel;
import com.framework.architecture.customerMgr.service.ICustomerService;
import com.framework.architecture.customerMgr.vo.CustomerModel;
import com.framework.architecture.customerMgr.vo.CustomerQueryModel;
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

		return "addCustomer";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("cm")CustomerModel cm) {

		cm.setRegisterTime(FormatHelper.long2Str(System.currentTimeMillis()));
		
		ics.insertModel(cm);
		
		return "success";
	}

	@RequestMapping(value="/toUpdate/{customerUuid}",method=RequestMethod.GET)
	public String toUpdate(@PathVariable("customerUuid")String uuid,Model model) {

		CustomerModel cm = ics.getModelByKey(uuid);
		
		model.addAttribute("cm", cm);
		
		return "updateCustomer";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("cm")CustomerModel cm) {
		ics.updateModel(cm);
		return "success";
	}

	@RequestMapping(value="/toDelete/{customerUuid}",method=RequestMethod.GET)
	public String toDelete(@PathVariable("customerUuid")String uuid,Model model) {

		CustomerModel cm = ics.getModelByKey(uuid);
		
		model.addAttribute("cm", cm);
		
		return "deleteCustomer";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String removeCustomer(@ModelAttribute("cm")CustomerModel cm) {

		ics.removeModel(cm.getUuid());
		
		return "success";
	}

	@RequestMapping(value="/toList",method=RequestMethod.GET)
	public String queryUser(@ModelAttribute("cwm")CustomerWebModel cwm,Model model){
		
		CustomerQueryModel cqm = null;
		if(cwm.getQueryJsonStr()==null||cwm.getQueryJsonStr().trim().length()==0){
			cqm = new CustomerQueryModel();
		}else{
			cqm = (CustomerQueryModel)JsonHelper.str2Obj(cwm.getQueryJsonStr(),CustomerQueryModel.class);
		}
		
		cqm.getPage().setNowPage(cwm.getNowPage());
		
		if(cwm.getPageShow()>0){
			cqm.getPage().setPageShow(cwm.getPageShow());
		}
		
		Page dbPage = ics.getListByConditionPage(cqm);
		
		model.addAttribute("cwm",cwm);
		model.addAttribute("page", dbPage);
		
		return "queryCustomers";
	}
}
