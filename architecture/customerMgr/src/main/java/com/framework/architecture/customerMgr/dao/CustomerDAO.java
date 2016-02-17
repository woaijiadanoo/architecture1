package com.framework.architecture.customerMgr.dao;

import org.springframework.stereotype.Repository;

import com.framework.architecture.common.base.dao.BaseDAO;
import com.framework.architecture.customerMgr.vo.CustomerModel;
import com.framework.architecture.customerMgr.vo.CustomerQueryModel;


@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel,CustomerQueryModel>{

	
}
