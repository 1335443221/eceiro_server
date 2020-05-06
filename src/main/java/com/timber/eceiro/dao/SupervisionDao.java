package com.timber.eceiro.dao;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface SupervisionDao {

		//app施工监护列表
			public List<Map<String, Object>> supervision_list(Map<String, Object> map);
			public List<Map<String, Object>> getReportTimeBySupervision(Map<String, Object> map);
			public List<Map<String, Object>> supervision_listByParams(Map<String, Object> map);
			public Map<String,Object> getDepartmentById(Map<String, Object> map);
			public int supervision_count(Map<String, Object> map);
			//app施工监护信息	
			public Map<String,Object> supervision_data(Map<String, Object> map);
		//app施工监护新增
			public int add_supervision(Map<String, Object> map);	
		//app施工监护时间类型列表
			public List<Map<String,Object>> supervision_time_list(Map<String, Object> map);	
		//app施工监护上报模板列表
			public List<Map<String,Object>> supervision_model_list(Map<String, Object> map);
		//app施工监护上报模板内容列表
			public List<Map<String,Object>> supervision_model_item_list(Map<String, Object> map);
		//app监护上报新增
			public int add_supervision_report(Map<String, Object> map);
		//app施工监护上报最新记录
			public List<Map<String,Object>> supervision_report_data(Map<String, Object> map);
		//app施工监护上报最新时间
			public Map<String,Object> supervision_report_last_time(Map<String, Object> map);


			
			//重置施工监护次数
			public int reset_supervision_day_count(Map<String, Object> map);
			
			//施工监护上报次数加1
			public int update_supervision_day_count(int supervision_id);
			public int update_supervision_state(int supervision_id);

		//app问题整改列表
			public List<Map<String,Object>> abarbeitung_list(Map<String, Object> map);
			//整改总数
			public int abarbeitung_list_count(Map<String, Object> map); 
		//app问题整改处理新增
			public int add_abarbeitung_report(Map<String, Object> map);
			//修改整改上报
			public int update_abarbeitung_report(Map<String, Object> map);
		//app问题整改新增
			public int add_abarbeitung(Map<String, Object> map);
			//修改整改
			public int update_abarbeitung(Map<String, Object> map);
		//app问题整改通知单信息
			public Map<String,Object> abarbeitung_data(Map<String, Object> map);
		//app问题整改报告信息
			public List<Map<String,Object>> abarbeitung_report_data(Map<String, Object> map);
			
			public int delete_save_abarbeitung_report(Map<String, Object> map);
			
			
			
		//app重要施工项列表
			public List<Map<String,Object>> construction_item_list(Map<String, Object> map); 
			//总数
			public int construction_item_count(Map<String, Object> map);
		//app重要施工项新增
			public int add_construction_item(Map<String, Object> map);
			//app重要施工项修改
			public int update_construction_item(Map<String, Object> map);
		//app重要施工项类型列表
			public List<Map<String,Object>> item_type_list(Map<String, Object> map);
		//app重要施工项证件类型列表
			public List<Map<String,Object>> item_credential_list(Map<String, Object> map);
		//app重要施工项详情信息
			public Map<String,Object> construction_item_data(Map<String, Object> map);	
			public Map<String,Object> load_construction_item_data(Map<String, Object> map);	
		//app加载重要施工项(已保存)
			public Object load_construction_item(Map<String, Object> map);	
		//app重要施工项上一个id
			public int construction_item_lastId(Map<String, Object> map);
			
		//app工程进度列表
			public List<Map<String, Object>> schedule_list(Map<String, Object> map);
			//总数
			public int schedule_count(Map<String, Object> map);
		//app工程进度最新
			public Map<String, Object> schedule_newData(Map<String, Object> map);
			//app工程进度最后一个id	
			public Integer schedule_lastId(Map<String, Object> map);
			
		//app工程进度信息
			public Map<String, Object> schedule_data(Map<String, Object> map);
		//app工程进度新增
			public int add_schedule(Map<String, Object> map);
			//app工程进度修改
			public int update_schedule(Map<String, Object> map);
		//app加载更多工程进度(历史信息)
			public Map<String, Object> loadmore_schedule(Map<String, Object> map);
		//加载工程进度(已保存)
			public Map<String, Object> load_schedule(Map<String, Object> map);
			
			
			
			////////////////////////////////web////////////////////
			//施工监护列表
			public List<Map<String,Object>> web_supervision_list(Map<String, Object> map);

			public List<Map<String,Object>> web_supervision_report_list(Map<String, Object> map);

			public List<Map<String,Object>> supervision_project_list(Map<String, Object> map);
			
			public Map<String,Object> web_supervision_data_ById(Map<String, Object> map);
			
			public List<Map<String,Object>> web_supervision_history(Map<String, Object> map);
			
			//问题整改列表
			public List<Map<String,Object>> web_abarbeitung_list(Map<String, Object> map);
			
			//重要施工项列表
			public List<Map<String,Object>> web_item_list(Map<String, Object> map);
			
			//工程进度列表
			public List<Map<String,Object>> web_schedule_list(Map<String, Object> map);

			public List<Map<String,Object>> web_check_report(Map<String, Object> map);
			public List<Map<String,Object>> supervision_report_time(Map<String, Object> map);
}
