package com.framework.architecture.goodsmgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framework.architecture.common.base.service.BaseService;

import com.framework.architecture.goodsmgr.dao.GoodsDAO;
import com.framework.architecture.goodsmgr.vo.GoodsModel;
import com.framework.architecture.goodsmgr.vo.GoodsQueryModel;

@Service
@Transactional
public class GoodsService extends BaseService<GoodsModel,GoodsQueryModel> implements IGoodsService{
	private GoodsDAO dao = null;
	@Autowired
	private void setDao(GoodsDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}