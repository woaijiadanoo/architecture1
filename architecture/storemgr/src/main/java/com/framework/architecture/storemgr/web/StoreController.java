package com.framework.architecture.storemgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.framework.architecture.storemgr.service.IStoreService;
import com.framework.architecture.storemgr.vo.StoreModel;
import com.framework.architecture.storemgr.vo.StoreQueryModel;
import com.framework.architecture.storemgr.web.vo.StoreWebModel;
import com.framework.architecture.pageutil.Page;
import com.framework.architecture.common.helpers.JsonHelper;

@Controller
@RequestMapping(value="/store")
public class StoreController {
	@Autowired
	private IStoreService iservice = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "store/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("m") StoreModel m){
		iservice.insertModel(m);
		return "redirect:toList";
	}
	@RequestMapping(value="toUpdate/{uuid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("uuid") String uuid){
		StoreModel m = iservice.getModelByKey(uuid);
		model.addAttribute("m", m);
		return "store/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@ModelAttribute("m") StoreModel m){
		iservice.updateModel(m);
		return "redirect:toList";
	}
	@RequestMapping(value="toDelete/{uuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("uuid") String uuid){
		StoreModel m = iservice.getModelByKey(uuid);
		model.addAttribute("m", m);
		return "store/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("uuid") int uuid){
		iservice.removeModel(uuid);
		return "redirect:toList";
	}
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")StoreWebModel wm,Model model){
		StoreQueryModel qm = null;
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			qm =  new StoreQueryModel();
		}else{
			String s = wm.getQueryJsonStr();
			s = s.replace("-", "%");
			qm = (StoreQueryModel)JsonHelper.str2Obj(s, StoreQueryModel.class);
		}
		
		qm.getPage().setNowPage(wm.getNowPage());
		if(wm.getPageShow() > 0){
			qm.getPage().setPageShow(wm.getPageShow());
		}
		
		Page dbPage = iservice.getListByConditionPage(qm);
		
		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", dbPage);
				
		return "store/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "store/query";
	}	
}
