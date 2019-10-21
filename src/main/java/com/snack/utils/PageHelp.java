package com.snack.utils;

import java.util.ArrayList;
import java.util.List;

public class PageHelp<T> {
	private int pageStart;
	private int pageSize; 			   			//页大小  
	private int pageIndex;           			//当前页号  
	private int record;              			//记录总数  
	private List<T> List=new ArrayList<T>();    //集合  
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecord() {
		return record;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageSize*pageIndex-pageSize;
	}
	public void setRecord(int record) {
		this.record = record;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<T> getList() {
		return List;
	}
	public void setList(List<T> list) {
		List = list;
	}

}
