package com.timber.eceiro.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommonDao {
	
	//app新增文件
	public int add_file_desc(Map<String, Object> map);
	//app获取文件集合
	public List<Map<String,Object>> getFileDescById(List list);
	//app删除图片
	public int deleteFileById(Map<String, Object> map);
	//app改变工程状态
	public int update_project_state(Map<String, Object> map);

	public int insertAudio(Map<String, Object> map);
	public int insertImage(Map<String, Object> map);
}
