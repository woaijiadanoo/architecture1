package com.framework.architecture.ordermgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framework.architecture.common.base.service.BaseService;

import com.framework.architecture.ordermgr.dao.OrderDetailDAO;
import com.framework.architecture.ordermgr.vo.OrderDetailModel;
import com.framework.architecture.ordermgr.vo.OrderDetailQueryModel;

@Service
@Transactional
public class OrderDetailService extends BaseService<OrderDetailModel,OrderDetailQueryModel> implements IOrderDetailService{
	private OrderDetailDAO dao = null;
	@Autowired
	private void setDao(OrderDetailDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}