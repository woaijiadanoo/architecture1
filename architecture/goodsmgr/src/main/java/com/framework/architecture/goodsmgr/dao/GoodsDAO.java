package com.framework.architecture.goodsmgr.dao;

import org.springframework.stereotype.Repository;
import com.framework.architecture.common.base.dao.BaseDAO;

import com.framework.architecture.goodsmgr.vo.GoodsModel;
import com.framework.architecture.goodsmgr.vo.GoodsQueryModel;

@Repository
public interface GoodsDAO extends BaseDAO<GoodsModel,GoodsQueryModel>{
	
}
