package com.framework.architecture.common.base.service;

import com.framework.architecture.pageutil.Page;

public interface IBaseService<M,QM> {

	public void insertModel(M m);
	
	public void updateModel(M m);
	
	public void removeModel(String key);
	
	public M getModelByKey(String key);
	
	public Page<M> getListByConditionPage(QM qm);
	
	
	
}
