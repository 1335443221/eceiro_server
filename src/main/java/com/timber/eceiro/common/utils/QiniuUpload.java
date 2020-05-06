package com.timber.eceiro.common.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.qiniu.cdn.CdnManager;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.timber.eceiro.common.config.UrlConfig;

 
/**
 * 七牛 java sdk 简单上传，覆盖上传，文件上传
 * @author yunlingfly
 */
public class QiniuUpload {
 
    Auth auth = Auth.create(UrlConfig.QiniuACCESS_KEY, UrlConfig.QiniuSECRET_KEY);
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone1());
    UploadManager uploadManager = new UploadManager(cfg);
    BucketManager bucketMgr = new BucketManager(auth, cfg);
    CdnManager c = new CdnManager(auth);
    /**
     * 简单上传的凭证token
     * @return
     */
    public static Object  getUpToken(Map<String, String> map){
    	if(map.get("bucket")==null){
    		return CodeMsg.MISSING_PARAMETER;
    	}
    	String accessKey = UrlConfig.QiniuACCESS_KEY;
        String secretKey = UrlConfig.QiniuSECRET_KEY;
        
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(map.get("bucket"));
		
		Map<String, String> map2=new HashMap<>();
        map2.put("upToken", upToken);
        return Result.success(map2);
    }
    
    
    /**
     * 简单上传的凭证token
     * @return
     */
    public static String  getUpToken2(){
    	String accessKey = UrlConfig.QiniuACCESS_KEY;
        String secretKey = UrlConfig.QiniuSECRET_KEY;
        
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(UrlConfig.QiniuBucketName);
		
        return upToken;
    }
    
    
    /**
     * 覆盖上传的凭证token 传入文件名字
     * @return
     */
    public static Object  getCoverUpToken(Map<String, String> map){
    	if(map.get("bucket")==null||map.get("covername")==null){
    		return CodeMsg.MISSING_PARAMETER;
    	}
    	
    	String accessKey = UrlConfig.QiniuACCESS_KEY;
        String secretKey = UrlConfig.QiniuSECRET_KEY;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(map.get("bucket"), map.get("covername"));
        Map<String, String> map2=new HashMap<>();
        map2.put("upToken", upToken);
        return Result.success(map2);
    }
    
    
    /**
     * 获取凭证
     * @param bucketName 空间名称
     * @param key 如果需要覆盖上传则设置此参数
     * @return
     */
    public String CoverToken(String bucketName,String key) {
        return auth.uploadToken(bucketName,key);
    }
    
    /**
     * 上传方法1
     * @param filePath 文件路径  （也可以是字节数组、或者File对象）
     * @param key 上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param bucketName 空间名称  （这里是为了获取上传凭证）
     */
    public void upload(String filePath, String key, String bucketName) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(filePath, key, CoverToken(bucketName,key));
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }
    
    /**
     * 上传方法2
     * @param file 文件
     * @param key 上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param bucketName 空间名称  （这里是为了获取上传凭证）
     */
    public  void upload(File file, String key, String bucketName) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(file, key, CoverToken(bucketName,key));
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }
 
    /**
     * 上传方法3 覆盖上传
     * @param path
     *            上传文件路径
     * @param bucketName
     *            空间名
     * @param key
     *            文件名
     */
    public void overrideUpload(String path, String key) {
        try {
            String token = CoverToken(UrlConfig.QiniuBucketName, key);//获取 token
            Response response = uploadManager.put(path, key, token);//执行上传，通过token来识别 该上传是“覆盖上传”
            System.out.println(response.toString());
        } catch (QiniuException e) {
            System.out.println(e.response.statusCode);
            e.printStackTrace();
        }
    }
    
    
    /**
     * 上传方法 删除 上传 刷新
     * @param path
     *            上传文件路径
     * @param bucketName
     *            空间名
     * @param key
     *            文件名
     */
    public void deleteAndUpload(String path, String key) {
    	
        try {
        	bucketMgr.delete(UrlConfig.QiniuBucketName, key);  //先删除
        	
        	String upToken = auth.uploadToken("ovelec_gt"); //获取token
            Response response = uploadManager.put(path, key, upToken);//执行上传，通过token来识别 该上传是“覆盖上传”
           
            String [] urls = {"http://gt.ovelec.com/index.html"};  //刷新
            c.refreshUrls(urls);
            
        } catch (QiniuException e) {
            System.out.println(e.response.statusCode);
            e.printStackTrace();
        }
    }
    
  
}
