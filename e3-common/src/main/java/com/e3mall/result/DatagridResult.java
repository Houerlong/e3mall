package com.e3mall.result;

import java.io.Serializable;
import java.util.List;

public class DatagridResult implements Serializable{
	private Integer total;
	private List<?> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
