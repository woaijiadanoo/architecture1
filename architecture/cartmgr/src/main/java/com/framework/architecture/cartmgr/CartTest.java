package com.framework.architecture.cartmgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.framework.architecture.cartmgr.service.ICartService;
import com.framework.architecture.cartmgr.vo.CartModel;
import com.framework.architecture.cartmgr.vo.CartQueryModel;
import com.framework.architecture.pageutil.Page;

@Service
public class CartTest {

	@Autowired
	//private CartDAO dao = null;
	private ICartService ics = null;
	public static void main(String[] args) {

		ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CartTest c = (CartTest) atx.getBean("cartTest");
		
		Page<CartModel> list = c.ics.getListByConditionPage(new CartQueryModel());
		
		for(CartModel cm : list.getResult()){
			System.out.println(cm);
		}
		
	}

}
