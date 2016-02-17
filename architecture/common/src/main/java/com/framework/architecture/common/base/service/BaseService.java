package com.framework.architecture.common.base.service;

import java.util.List;

import com.framework.architecture.common.base.dao.BaseDAO;
import com.framework.architecture.common.base.vo.BaseModel;
import com.framework.architecture.pageutil.Page;

public class BaseService<M,QM extends BaseModel> implements IBaseService<M,QM> {

	private BaseDAO<M, QM> dao;
	public void setDao(BaseDAO<M, QM> dao){
		this.dao = dao;
	}
	
	@Override
	public void insertModel(M m) {
		dao.insertModel(m);
	}

	@Override
	public void updateModel(M m) {
		dao.updateModel(m);
	}

	@Override
	public void removeModel(String key) {
		dao.removeModel(key);
	}

	@Override
	public M getModelByKey(String key) {
		return dao.getModelByKey(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<M> getListByConditionPage(QM qm) {
		List<M> result = dao.getListByConditionPage(qm);
		qm.getPage().setResult(result);
		
		return qm.getPage();
	}

}
