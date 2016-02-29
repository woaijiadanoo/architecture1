package com.framework.architecture.cartmgr.dao;

import org.springframework.stereotype.Repository;
import com.framework.architecture.common.base.dao.BaseDAO;

import com.framework.architecture.cartmgr.vo.CartModel;
import com.framework.architecture.cartmgr.vo.CartQueryModel;

@Repository
public interface CartDAO extends BaseDAO<CartModel,CartQueryModel>{
	
}
