package com.framework.architecture.common.base.dao;

import java.util.List;

public interface BaseDAO<M,QM> {

	public void insertModel(M m);
	
	public void updateModel(M m);
	
	public void removeModel(String key);
	
	public M getModelByKey(String key);
	
	public List<M> getListByConditionPage(QM qm);
	
}
