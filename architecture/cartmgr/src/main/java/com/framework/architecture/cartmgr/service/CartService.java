package com.framework.architecture.cartmgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framework.architecture.common.base.service.BaseService;

import com.framework.architecture.cartmgr.dao.CartDAO;
import com.framework.architecture.cartmgr.vo.CartModel;
import com.framework.architecture.cartmgr.vo.CartQueryModel;

@Service
@Transactional
public class CartService extends BaseService<CartModel,CartQueryModel> implements ICartService{
	private CartDAO dao = null;
	@Autowired
	private void setDao(CartDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}