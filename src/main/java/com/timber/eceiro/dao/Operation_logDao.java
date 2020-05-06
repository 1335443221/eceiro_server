package com.timber.eceiro.dao;

import com.timber.eceiro.common.utils.PageUtil;
import com.timber.eceiro.entity.Operation_log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Operation_logDao {
	
	
	public List<Operation_log> findPage(PageUtil<Operation_log> page);
	
	
	public List<Operation_log> findPage2(PageUtil<Operation_log> page);
	
	public void insertOperation_log(Map<String, Object> map);
	
	

	
}
