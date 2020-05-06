package com.timber.eceiro.dao;

import com.timber.eceiro.common.utils.PageUtil;
import com.timber.eceiro.entity.TipInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface TipDao {
	
	public ArrayList<TipInfo> getAllTip(String Stg);
	
	public List<TipInfo> findPage(PageUtil<TipInfo> page);
	
	public TipInfo getTipById(Integer id);
	
	public int insertTip(Map<String, Object> map);
	
	public void deleteTipById(Integer id);
	
	public int updateTipById(Map<String, Object> map);
	
	public int getMaxIdTip();
	
	
}
