package com.framework.architecture.ordermgr.dao;

import org.springframework.stereotype.Repository;
import com.framework.architecture.common.base.dao.BaseDAO;

import com.framework.architecture.ordermgr.vo.OrderModel;
import com.framework.architecture.ordermgr.vo.OrderQueryModel;

@Repository
public interface OrderDAO extends BaseDAO<OrderModel,OrderQueryModel>{
	
}
