package com.framework.architecture.storemgr.dao;

import org.springframework.stereotype.Repository;
import com.framework.architecture.common.base.dao.BaseDAO;

import com.framework.architecture.storemgr.vo.StoreModel;
import com.framework.architecture.storemgr.vo.StoreQueryModel;

@Repository
public interface StoreDAO extends BaseDAO<StoreModel,StoreQueryModel>{
	
}
