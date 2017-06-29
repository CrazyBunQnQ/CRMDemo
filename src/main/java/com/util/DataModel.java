package com.util;

import java.util.List;
/**
 * 
 *封装了 分页对象 以及数据集合  
 *
 * @param <T>
 */
public class DataModel<T> {
	
	private Pager pager;
	private List<T> rows ;    //结果集
	
	public DataModel() {
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}


}
