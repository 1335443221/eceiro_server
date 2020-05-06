package com.timber.eceiro.dao;

import com.timber.eceiro.entity.PatrolInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface PatrolDao {
	
	public ArrayList<PatrolInfo> getAllPatrol(String rname);
	
	public List<Map<String,Object>> findPage(Map<String, Object> page);

	public List<Map<String,Object>> patrol_type_list(Map<String, Object> page);

	public List<Map<String,Object>> patrol_time_list(Map<String, Object> page);

	public PatrolInfo getPatrolById(Integer id);
	
	public void insertPatrol(PatrolInfo PatrolInfo);
	
	public void deletePatrolById(Integer id);
	
	public void deletePatrolByPId(Integer id);
	
	public void updatePatrolById(PatrolInfo PatrolInfo);
	

	
}
