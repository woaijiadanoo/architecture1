package com.framework.architecture.goodsmgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.framework.architecture.goodsmgr.service.IGoodsService;
import com.framework.architecture.goodsmgr.vo.GoodsModel;
import com.framework.architecture.goodsmgr.vo.GoodsQueryModel;
import com.framework.architecture.goodsmgr.web.vo.GoodsWebModel;
import com.framework.architecture.pageutil.Page;
import com.framework.architecture.common.helpers.JsonHelper;

@Controller
@RequestMapping(value="/goods")
public class GoodsController {
	@Autowired
	private IGoodsService iservice = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "goods/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("m") GoodsModel m){
		iservice.insertModel(m);
		return "redirect:toList";
	}
	@RequestMapping(value="toUpdate/{uuid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("uuid") String uuid){
		GoodsModel m = iservice.getModelByKey(uuid);
		model.addAttribute("m", m);
		return "goods/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@ModelAttribute("m") GoodsModel m){
		iservice.updateModel(m);
		return "redirect:toList";
	}
	@RequestMapping(value="toDelete/{uuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("uuid") String uuid){
		GoodsModel m = iservice.getModelByKey(uuid);
		model.addAttribute("m", m);
		return "goods/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("uuid") int uuid){
		iservice.removeModel(uuid);
		return "redirect:toList";
	}
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")GoodsWebModel wm,Model model){
		GoodsQueryModel qm = null;
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			qm =  new GoodsQueryModel();
		}else{
			String s = wm.getQueryJsonStr();
			s = s.replace("-", "%");
			qm = (GoodsQueryModel)JsonHelper.str2Obj(s, GoodsQueryModel.class);
		}
		
		qm.getPage().setNowPage(wm.getNowPage());
		if(wm.getPageShow() > 0){
			qm.getPage().setPageShow(wm.getPageShow());
		}
		
		Page dbPage = iservice.getListByConditionPage(qm);
		
		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", dbPage);
				
		return "goods/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "goods/query";
	}	
}
