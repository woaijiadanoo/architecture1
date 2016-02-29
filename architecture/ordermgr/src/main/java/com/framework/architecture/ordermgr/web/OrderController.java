package com.framework.architecture.ordermgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.framework.architecture.ordermgr.service.IOrderService;
import com.framework.architecture.ordermgr.vo.OrderModel;
import com.framework.architecture.ordermgr.vo.OrderQueryModel;
import com.framework.architecture.ordermgr.web.vo.OrderWebModel;
import com.framework.architecture.pageutil.Page;
import com.framework.architecture.common.helpers.JsonHelper;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	@Autowired
	private IOrderService iservice = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "order/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("m") OrderModel m){
		iservice.insertModel(m);
		return "redirect:toList";
	}
	@RequestMapping(value="toUpdate/{uuid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("uuid") String uuid){
		OrderModel m = iservice.getModelByKey(uuid);
		model.addAttribute("m", m);
		return "order/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@ModelAttribute("m") OrderModel m){
		iservice.updateModel(m);
		return "redirect:toList";
	}
	@RequestMapping(value="toDelete/{uuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("uuid") String uuid){
		OrderModel m = iservice.getModelByKey(uuid);
		model.addAttribute("m", m);
		return "order/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("uuid") int uuid){
		iservice.removeModel(uuid);
		return "redirect:toList";
	}
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")OrderWebModel wm,Model model){
		OrderQueryModel qm = null;
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			qm =  new OrderQueryModel();
		}else{
			String s = wm.getQueryJsonStr();
			s = s.replace("-", "%");
			qm = (OrderQueryModel)JsonHelper.str2Obj(s, OrderQueryModel.class);
		}
		
		qm.getPage().setNowPage(wm.getNowPage());
		if(wm.getPageShow() > 0){
			qm.getPage().setPageShow(wm.getPageShow());
		}
		
		Page dbPage = iservice.getListByConditionPage(qm);
		
		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", dbPage);
				
		return "order/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "order/query";
	}	
}
