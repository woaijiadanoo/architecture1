package com.framework.architecture.ordermgr.dao;

import org.springframework.stereotype.Repository;
import com.framework.architecture.common.base.dao.BaseDAO;

import com.framework.architecture.ordermgr.vo.OrderDetailModel;
import com.framework.architecture.ordermgr.vo.OrderDetailQueryModel;

@Repository
public interface OrderDetailDAO extends BaseDAO<OrderDetailModel,OrderDetailQueryModel>{
	
}
