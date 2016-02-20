package com.framework.architecture.customerMgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framework.architecture.customerMgr.service.ICustomerService;
import com.framework.architecture.customerMgr.vo.CustomerModel;
import com.framework.architecture.customerMgr.vo.CustomerQueryModel;


@Service
@Transactional
public class CustomerDAOTest {

	@Autowired
	private ICustomerService service;
	private static ApplicationContext atc;

	public ICustomerService getService(){
		return service;
	}



	public static void main(String[] args) {

		atc = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CustomerDAOTest cdt = (CustomerDAOTest)atc.getBean("customerDAOTest");
		
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("c3");
		cm.setPwd("c3");
		cm.setRegisterTime("c3");
		cm.setShowName("c3");
		cm.setTrueName("张三");
		
		//cdt.customerDao.addCustomer(cm);
		
		
		CustomerQueryModel cqm = new CustomerQueryModel();
		cqm.getPage().setNowPage(0);
		cqm.getPage().setPageShow(5);
		
		System.out.println(cdt.getService().getListByConditionPage(cqm));
		
	}

}
