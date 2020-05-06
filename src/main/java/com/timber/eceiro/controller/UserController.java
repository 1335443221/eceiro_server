package com.timber.eceiro.controller;

import com.timber.eceiro.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gtgx")
public class UserController {
	@Autowired
    UserDataService userDataImpl;

	
	
	/**
	 * 登陆页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		return "gtgxPag/login";
	}


	/**
	 * app登录
	 * @param
	 * @return
	 */
	@RequestMapping("/applogin")
	@ResponseBody
	public Object applogin(@RequestParam Map<String, Object> map){
		return userDataImpl.getAllUser(map);
	}
	
	/**
	 * 后台管理主页面
	 * @param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/index")
	public String index(String tg) throws UnsupportedEncodingException{
		return "gtgxPag/index";
	}

}
