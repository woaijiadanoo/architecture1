package com.framework.architecture.customerMgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framework.architecture.common.base.service.BaseService;
import com.framework.architecture.customerMgr.dao.CustomerDAO;
import com.framework.architecture.customerMgr.vo.CustomerModel;
import com.framework.architecture.customerMgr.vo.CustomerQueryModel;

@Service
@Transactional
public class CustomerService extends BaseService<CustomerModel,CustomerQueryModel> implements ICustomerService {

	@SuppressWarnings("unused")
	private CustomerDAO dao = null;
	@Autowired
	public void setDAO(CustomerDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}
