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
	
	public void insertModel(M m) {
		dao.insertModel(m);
	}

	public void updateModel(M m) {
		dao.updateModel(m);
	}

	public void removeModel(String key) {
		dao.removeModel(key);
	}

	public M getModelByKey(String key) {
		return dao.getModelByKey(key);
	}

	@SuppressWarnings("unchecked")
	public Page<M> getListByConditionPage(QM qm) {
		List<M> result = dao.getListByConditionPage(qm);
		qm.getPage().setResult(result);
		
		return qm.getPage();
	}

}
