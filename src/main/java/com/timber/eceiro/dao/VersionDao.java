package com.timber.eceiro.dao;

import com.timber.eceiro.common.utils.PageUtil;
import com.timber.eceiro.entity.VersionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface VersionDao {
	
	public ArrayList<VersionInfo> getAllVersion(String gname);
	
	public List<VersionInfo> findPage(PageUtil<VersionInfo> page);
	
	public VersionInfo getVersionById(Integer id);
	
	public VersionInfo getMaxIdVersion();
	
	public int insertVersion(VersionInfo VersionInfo);
	
	public void deleteVersionById(Integer id);
	
	public int updateVersionById(VersionInfo VersionInfo);
	
	public List<VersionInfo> checkName(String name);
	
	public ArrayList<VersionInfo> checkVersion(Map<String, Object> map);
	
	
	public Map<String, Object>  getMaxIdQrCode();
	
	public int insertQrCode(Map<String, Object> map);
	
	
}
