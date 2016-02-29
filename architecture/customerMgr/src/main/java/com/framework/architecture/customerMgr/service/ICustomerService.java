package com.framework.architecture.customerMgr.service;


import org.springframework.transaction.annotation.Transactional;

import com.framework.architecture.common.base.service.IBaseService;
import com.framework.architecture.customerMgr.vo.CustomerModel;
import com.framework.architecture.customerMgr.vo.CustomerQueryModel;

@Transactional
public interface ICustomerService extends IBaseService<CustomerModel, CustomerQueryModel>{

	public CustomerModel getCusomerByID(String CustomerID);
	
}
