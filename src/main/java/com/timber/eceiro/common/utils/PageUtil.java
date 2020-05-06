package com.timber.eceiro.common.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil<T> implements Serializable{
	private int pagesize=17;  //页大小
	private int pageindex; //页码
	private int recordCount; //总记录数
	private int totalPagecount; //总页数
	private List<T> data;   //分页查询的数据
    private Map<String, Object> params = new HashMap<String, Object>();		//其他的参数我们把它分装成一个Map对象

	
	//计算总页数
	public int  getTotalPagecount(){
		totalPagecount = recordCount%pagesize==0 ? recordCount/pagesize :recordCount/pagesize+1;
		return totalPagecount;
	}
	
	//计算首页
	public int getFirstPage(){
	 	return pageindex =1;
	}
	
	//计算上一页
	public int getLastPage(){
		int i=pageindex;
		if(i!=1){
			i=i-1;
		}else{
			i=1;
		}
		return i;
	}
	
	//计算下一页
	public int  getNextpage(int totalPagecount){
		int i=pageindex;
		if (pageindex <totalPagecount){
			i=pageindex+1;
		}else{
			i=totalPagecount;
		}
		return i;
	}
	
	//计算末页
	public int getEndPage(){
		return pageindex=totalPagecount;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


	
	
	
	

	public int getPageindex() {
		return pageindex;
	}

	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public void setTotalPagecount(int totalPagecount) {
		this.totalPagecount = totalPagecount;
	}
 	
}
