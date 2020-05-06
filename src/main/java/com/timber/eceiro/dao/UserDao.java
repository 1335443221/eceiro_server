package com.timber.eceiro.dao;

import com.timber.eceiro.common.utils.PageUtil;
import com.timber.eceiro.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Mapper
public interface UserDao {
	public ArrayList<String> getTags(String Stg);
	
	public ArrayList<UserInfo> getAllUser(Map<String, Object> map);
	
	public Map<String, Object> getUserinfoById(Integer id);
	
	public UserInfo getMaxIdUser();
	
	
	public List<UserInfo> getSupportList(List list);
	
	public void deleteUserById(Integer id);
	
	public int updateUserinfo(Map<String, Object> map);
	
	public int insertUser(Map<String, Object> map);
	
	public List<Map<String,Object>> findPage(PageUtil<Map<String, Object>> page);

	public ArrayList<Map<String, Object>> checkUser(Map<String, Object> map);
	public ArrayList<UserInfo> checkJob_number(String sta);
	public ArrayList<UserInfo> checkCellphone(Map<String, Object> map);
	public ArrayList<UserInfo> checkLogin_name(String sta);
	public ArrayList<Map<String, Object>> checkDelete(Map<String, Object> map);

	public Map<String,Object> checkAppLogin(Map<String, Object> map);

	public ArrayList<Map<String,Object>> getQiNiuBucket(Map<String, Object> map);

	public Map<String, Object> getSession(Map<String, Object> map);
	public int insertSession(Map<String, Object> map);

	public ArrayList<Map<String, Object>> getAllRongUser(Map<String, Object> map);

}
