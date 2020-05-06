package com.timber.eceiro.service;


import com.timber.eceiro.dao.RongCloudDao;
import com.timber.eceiro.dao.UserDao;
import com.timber.eceiro.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author lixuri
 * @date 2019-9-20 17:23:20
 */
@Service("userDataImpl")
public class UserDataService{

	
	@Autowired
	private UserDao userDao;


	public ArrayList<UserInfo> getAllUser(Map<String, Object> map) {
		return userDao.getAllUser(map);
	}



}
