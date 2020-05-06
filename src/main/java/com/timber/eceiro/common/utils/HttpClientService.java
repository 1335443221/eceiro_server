package com.timber.eceiro.common.utils;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author cloud
 * @description
 * @date 2017年06月15日
 */
@Service
public class HttpClientService {

  private final Logger logger = LoggerFactory.getLogger(HttpClientService.class);

  private CloseableHttpClient httpClient;
  private RequestConfig requestConfig;

  /**
   * 处理get请求.
   *
   * @return json
   */
public  String get(String GET_URL,Map<String,Object> map){
	GetParam getParam=new GetParam();
	try {
		String params = getParam.getParams(map);
        URL url = new URL(GET_URL+"?"+params);    // 把字符串转换为URL请求地址
        System.out.println(url);
       HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
       connection.connect();// 连接会话
       // 获取输入流
       BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {// 循环读取流
           sb.append(line);
        }
        br.close();// 关闭流
       connection.disconnect();// 断开连接
      return  sb.toString();
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("失败!");
        return null;
    }

}

    public  String RestGet(String GET_URL,Map<String,Object> map) {
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(GET_URL,String.class);
        String b = responseEntity.getBody();
        return b;
    }
    public  String RestPost(String GET_URL,Map<String,Object> map) {
        RestTemplate restTemplate= new RestTemplate();
        String b4 =restTemplate.postForObject(GET_URL,map,String.class);
        return b4;
    }


/**
 * 处理post请求.
 *
 * @param url 请求路径
 * @param params 参数
 * @return json
 */
public String post(String url, Map<String, String> params) {
  logger.info("请求地址(post)：" + url);
  //结果
  String content = "";
  httpClient =  new DefaultHttpClient();
  try {
    //实例化post方法
    HttpPost httpPost = new HttpPost(url);
    httpPost.setConfig(requestConfig);
    //处理参数
    List<NameValuePair> nvps = new ArrayList<>();
    if (params != null) {
      Set<String> keySet = params.keySet();
      for (String key : keySet) {
        nvps.add(new BasicNameValuePair(key, params.get(key)));
      }
    }
    //提交的参数
    UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
    //将参数给post方法
    httpPost.setEntity(uefEntity);
    //执行post方法
    CloseableHttpResponse response = httpClient.execute(httpPost);
    if (response.getStatusLine().getStatusCode() == 200) {
      content = EntityUtils.toString(response.getEntity(), "utf-8");
      logger.info("HTTP请求返回参数(post)：" + content);
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
  return content;
}

@SuppressWarnings("resource")
public static String doPost(String url,String jsonstr,String charset){
    HttpClient httpClient = null;
    HttpPost httpPost = null;
    String result = null;
    try{
        httpClient =  new DefaultHttpClient();
        httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        StringEntity se = new StringEntity(jsonstr);
        se.setContentType("text/json");
        se.setContentEncoding(new BasicHeader("Content-Type", "application/json"));
        httpPost.setEntity(se);
        HttpResponse response = httpClient.execute(httpPost);
        if(response != null){
            HttpEntity resEntity = response.getEntity();
            if(resEntity != null){
                result = EntityUtils.toString(resEntity,charset);
            }
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return result;
}

public static void main(String[] args) {
	HttpClientService hc=new HttpClientService();
	Map<String, String> map=new HashMap<>();
	map.put("token", "3a00f2a2b2cff49e49d969a1b12d3229621b52d7307e9db4c74a497774745d0d9837bf3dd5d66a805f5b361c20aade2cb209ea1db599f20e7249ff65e85829a7Gliymg3gcJcTQiM1ititSrGSjB0yf+d2hqWIfaP/DOlyNaxnUeqXZO2VEauwr459dVo6HI2i+oUo4mMRuk9YUIPCWz114Z86MTpcLramCMU=");
	String a=hc.post("http://192.168.0.50:21111/gaoxin_app/api/v1/user/decrypt_token",map);
	System.out.println(a);
	
	
	
	RestTemplate restTemplate= new RestTemplate();
	ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://192.168.0.50:21111/gaoxin_app/api/v1/user/decrypt_token", map, String.class);
	String b = responseEntity.getBody();
	System.out.println(b);

	/*Map<String, Object> map2=new HashMap<>();
	map2.put("token", "3a00f2a2b2cff49e49d969a1b12d3229621b52d7307e9db4c74a497774745d0d9837bf3dd5d66a805f5b361c20aade2cb209ea1db599f20e7249ff65e85829a7Gliymg3gcJcTQiM1ititSrGSjB0yf+d2hqWIfaP/DOlyNaxnUeqXZO2VEauwr459dVo6HI2i+oUo4mMRuk9YUIPCWz114Z86MTpcLramCMU=");
	
//	//1...
//	ResponseEntity<String> responseEntity2 = restTemplate.postForEntity("http://192.168.0.60:21107/run/getCoilin_detail?token={token}&panel_id={panel_id}&device_name={device_name}&tg_id={tg_id}",map2,String.class,map2);
//	String b2 = responseEntity2.getBody();
//	System.out.println(b2);
//	
//	//2...
//	String b3 =restTemplate.postForObject("http://192.168.0.60:21107/run/getCoilin_detail?token={token}&panel_id={panel_id}&device_name={device_name}&tg_id={tg_id}",map2,String.class,map2);
//	System.out.println(b3);
	
	
	
	MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
	paramMap.add("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJ1c2VyX2lkIjoie3VpZD0yOCwgb3Blcl9wd2Q9ZDBlMWUyZGM5NDczY2RiMzAxZjdlOTdkZTNiZGEzY2R9IiwiaXNzIjoiU2VydmljZSIsImV4cCI6MTU1MzczNjI5NywiaWF0IjoxNTUyODcyMjk3fQ.GOCgGdxKTL8ORarfzrtpf0YYWswMF1yZiljhp10S8e4");
	paramMap.add("panel_id", 2);
	paramMap.add("device_name", "a1_b9");
	paramMap.add("tg_id", "TG10");
	
//	//3...
//	String b4 =restTemplate.postForObject("http://192.168.0.60:21107/run/getCoilin_detail",paramMap,String.class);
//	System.out.println(b4);
	
	//4...
	String b5=restTemplate.getForObject("http://192.168.0.60:21107/run/getCoilin_detail?token={token}&panel_id={panel_id}&device_name={device_name}&tg_id={tg_id}",String.class,map2);
	System.out.println(b5);*/


}


}