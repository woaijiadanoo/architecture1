package com.framework.architecture.common.base.vo;

import java.io.Serializable;

import com.framework.architecture.pageutil.Page;

public class BaseModel  implements Serializable{

	private int uuid;
	private Page page = new Page();

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	
	
	
}
