package com.framework.architecture.cartmgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.framework.architecture.cartmgr.service.ICartService;
import com.framework.architecture.cartmgr.vo.CartModel;
import com.framework.architecture.cartmgr.vo.CartQueryModel;
import com.framework.architecture.cartmgr.web.vo.CartWebModel;
import com.framework.architecture.pageutil.Page;
import com.framework.architecture.common.helpers.JsonHelper;

@Controller
@RequestMapping(value="/cart")
public class CartController {
	@Autowired
	private ICartService iservice = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "cart/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("m") CartModel m){
		iservice.insertModel(m);
		return "redirect:toList";
	}
	@RequestMapping(value="toUpdate/{uuid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("uuid") String uuid){
		CartModel m = iservice.getModelByKey(uuid);
		model.addAttribute("m", m);
		return "cart/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@ModelAttribute("m") CartModel m){
		iservice.updateModel(m);
		return "redirect:toList";
	}
	@RequestMapping(value="toDelete/{uuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("uuid") String uuid){
		CartModel m = iservice.getModelByKey(uuid);
		model.addAttribute("m", m);
		return "cart/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("uuid") int uuid){
		iservice.removeModel(uuid);
		return "redirect:toList";
	}
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")CartWebModel wm,Model model){
		CartQueryModel qm = null;
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			qm =  new CartQueryModel();
		}else{
			String s = wm.getQueryJsonStr();
			s = s.replace("-", "%");
			qm = (CartQueryModel)JsonHelper.str2Obj(s, CartQueryModel.class);
		}
		
		qm.getPage().setNowPage(wm.getNowPage());
		if(wm.getPageShow() > 0){
			qm.getPage().setPageShow(wm.getPageShow());
		}
		
		Page dbPage = iservice.getListByConditionPage(qm);
		
		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", dbPage);
				
		return "cart/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "cart/query";
	}	
}
