package com.framework.architecture.ordermgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framework.architecture.common.base.service.BaseService;

import com.framework.architecture.ordermgr.dao.OrderDAO;
import com.framework.architecture.ordermgr.vo.OrderModel;
import com.framework.architecture.ordermgr.vo.OrderQueryModel;

@Service
@Transactional
public class OrderService extends BaseService<OrderModel,OrderQueryModel> implements IOrderService{
	private OrderDAO dao = null;
	@Autowired
	private void setDao(OrderDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}