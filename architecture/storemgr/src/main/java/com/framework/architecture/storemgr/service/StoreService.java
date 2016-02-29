package com.framework.architecture.storemgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framework.architecture.common.base.service.BaseService;

import com.framework.architecture.storemgr.dao.StoreDAO;
import com.framework.architecture.storemgr.vo.StoreModel;
import com.framework.architecture.storemgr.vo.StoreQueryModel;

@Service
@Transactional
public class StoreService extends BaseService<StoreModel,StoreQueryModel> implements IStoreService{
	private StoreDAO dao = null;
	@Autowired
	private void setDao(StoreDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}