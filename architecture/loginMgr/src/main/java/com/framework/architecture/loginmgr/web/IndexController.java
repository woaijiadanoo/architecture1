package com.framework.architecture.loginmgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.architecture.cartmgr.service.ICartService;
import com.framework.architecture.cartmgr.vo.CartModel;
import com.framework.architecture.cartmgr.vo.CartQueryModel;
import com.framework.architecture.goodsmgr.service.IGoodsService;
import com.framework.architecture.goodsmgr.vo.GoodsModel;
import com.framework.architecture.goodsmgr.vo.GoodsQueryModel;
import com.framework.architecture.ordermgr.service.IOrderDetailService;
import com.framework.architecture.ordermgr.service.IOrderService;
import com.framework.architecture.pageutil.Page;
import com.framework.architecture.storemgr.service.IStoreService;

@Controller
@RequestMapping(value="/")
public class IndexController {

	@Autowired
	private IGoodsService igs = null;
	@Autowired
	private ICartService ics = null;
	@Autowired
	private IOrderService ios = null;
	@Autowired
	private IOrderDetailService iods = null;
	@Autowired
	private IStoreService iss = null;
	
	public IGoodsService getIgs() {
		return igs;
	}
	public ICartService getIcs() {
		return ics;
	}
	public IOrderService getIos() {
		return ios;
	}
	public IOrderDetailService getIods() {
		return iods;
	}
	public IStoreService getIss() {
		return iss;
	}


	@RequestMapping(value="/toIndex",method=RequestMethod.GET)
	public String toIndex(Model model){
		GoodsQueryModel gqm = new GoodsQueryModel();
		gqm.getPage().setPageShow(100);
		
		Page<GoodsModel> page = igs.getListByConditionPage(gqm);
		
		model.addAttribute("page",page);
		
		return "index";
	}
	
	
	@RequestMapping(value="/toGoodsDesc/{goodsUuid}",method=RequestMethod.GET)
	public String toGoodsDesc(Model model,@PathVariable("goodsUuid")int goodsUuid){
		GoodsModel gm = igs.getModelByKey(goodsUuid+"");
		
		model.addAttribute("m",gm);
		return "goods/desc";
	}
	
	@RequestMapping(value="/addToCart/{goodsUuid}",method=RequestMethod.GET)
	public String addToCart(Model model,@PathVariable("goodsUuid")int goodsUuid,@CookieValue("myCookie")String myLogin){
		int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
		
		CartModel cm = new CartModel();
		cm.setBuyNum(1);
		cm.setCustomerUuid(customerUuid);
		cm.setGoodsUuid(goodsUuid);
		
		ics.insertModel(cm);
		///////////////////////////
		CartQueryModel cqm = new CartQueryModel();
		cqm.getPage().setPageShow(1000);
		cqm.setCustomerUuid(customerUuid);
		
		
		Page<CartModel>  page = ics.getListByConditionPage(cqm);
		
		model.addAttribute("page",page);
		
		return "cart/myCart";
	}
	@RequestMapping(value="/toCart",method=RequestMethod.GET)
	public String toCart(Model model,@CookieValue("myCookie")String myLogin){
		int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
		
		CartQueryModel cqm = new CartQueryModel();
		cqm.getPage().setPageShow(1000);
		cqm.setCustomerUuid(customerUuid);
		
		Page<CartModel>  page = ics.getListByConditionPage(cqm);
		
		model.addAttribute("page",page);
		
		return "cart/myCart";
	}
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public String order(){//@CookieValue("MyLogin")String myLogin){
		//1:查出这个人购物车所有的信息		
		int customerUuid = 1;//Integer.parseInt( myLogin.split(",")[0]);
		
//		ios.order(customerUuid);
		
		return "success";
	}
	
}
