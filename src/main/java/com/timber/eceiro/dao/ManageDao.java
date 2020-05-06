package com.timber.eceiro.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManageDao {
	
	//获取工程信息通过project_id
		public Map<String,Object> getProjectById(Map<String, Object> map);
	//app工程列表
		public List<Map<String,Object>> project_list(Map<String, Object> map);
		public int project_list_count(Map<String, Object> map);
	//app工程结算列表
		public String project_settlement_list_name(Map<String, Object> map);
		public int project_settlement_list_count(Map<String, Object> map);
	//app工程类型列表
		public List<Map<String,Object>> project_type_list(Map<String, Object> map);
	//app工程新增
		public int add_project(Map<String, Object> map);
		//app工程修改
		public int update_project(Map<String, Object> map);
	//app工程前期信息通过project_id获取	
		public Map<String,Object> project_early_data(Map<String, Object> map);
	//app工程前期新增
		public int add_project_early(Map<String, Object> map);
	//app工程前期修改
		public int update_project_early(Map<String, Object> map);
		
		public Integer project_state_create(Map<String, Object> map);
		
		
	//app工程开工信息通过project_id获取	
		public Map<String,Object> project_start_data(Map<String, Object> map);
	//app工程开工新增
		public int add_project_start(Map<String, Object> map);
	//app工程开工修改
		public int update_project_start(Map<String, Object> map);
		
		
	//app工程预验收信息通过project_id获取	
		public Map<String,Object> project_before_check_data(Map<String, Object> map);
	//app工程预验收新增
		public int add_project_before_check(Map<String, Object> map);
	//app工程预验收修改
		public int update_project_before_check(Map<String, Object> map);
		
		
	//app工程验收信息通过project_id获取	
		public Map<String,Object> project_check_data(Map<String, Object> map);
	//app工程验收新增
		public int add_project_check(Map<String, Object> map);
	//app工程验收修改
		public int update_project_check(Map<String, Object> map);
		
		
	//app工程结算类型列表
		public List<Map<String,Object>> project_settlement_type_list(Map<String, Object> map);
	//app工程结算信息通过project_id获取	
		public Map<String,Object> project_settlement_detail(Map<String, Object> map);
	//app工程结算新增
		public int add_project_settlement(Map<String, Object> map);
		public int update_project_contract_amount(Map<String, Object> map); 
		
		public Map<String,Object>  project_contract_amount(Map<String, Object> map);
		
	//app工程结算修改
		public int update_project_settlement(Map<String, Object> map);
	//app工程结算最小id
		public int project_settlement_lastId(Map<String, Object> map);
		
		
//web端-================================================================================
	//获取工程报表
		public List<Map<String,Object>> showProjectLog(Map<String, Object> map);
	//web工程信息
		public List<Map<String,Object>> web_project_list(Map<String, Object> map);
		public List<Map<String,Object>> web_project_type_list(Map<String, Object> map);
		public List<Map<String,Object>> web_project_state_list(Map<String, Object> map);
		public Map<String,Object> web_project_data_ById(Map<String, Object> map);
		
		//结算列表
		public List<Map<String,Object>> web_project_settlement_list(Map<String, Object> map);
		public List<Map<String,Object>> web_update_settlement_list(Map<String, Object> map);
		
		public Map<String,Object> project_settlement_ById(Map<String, Object> map);
		
		
		public int abarbeitungCountByPid(Map<String, Object> map);
		public Map<String,Object> settlementAmountByPid(Map<String, Object> map);
		
		
}

