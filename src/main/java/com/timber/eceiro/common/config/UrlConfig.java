package com.timber.eceiro.common.config;

import org.springframework.stereotype.Service;

import cn.jpush.api.push.model.audience.Audience;

@Service
public class UrlConfig {
	public static final String PROFILES_ACTIVE="dev";    //配置当前状态  dev测试  sale推广  prod生产

	//融云
	public static final String Dev_RongAppKey = "k51hidwqk4nsb";
	public static final String Prod_RongAppKey = "tdrvipkstyq45";
	public static  String RongAppKey = "";

	public static final String Dev_RongAppSecret = "u7Ud2n4c9jsm";
	public static final String Prod_RongAppSecret = "oKvlHrYII8pky";
	public static  String RongAppSecret = "";


	public static final String GroupPortrait = "http://123.57.209.56:21112/Portrait/groupPortrait.png";  //默认群头像
	public static final String UserPortrait = "http://123.57.209.56:21112/Portrait/userPortrait.png";  //默认用户头像
	public static final String DEFAULT_RONG_USER_Id = "rong_prod_27";  //默认用户的融云id 用来发送默认信息

	public static final String HuangLiUrl = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php";  //黄历
	public static final String WeatherUrl = "http://t.weather.sojson.com/api/weather/city/101010100";  //北京天气

	//七牛
	public static final String QiniuACCESS_KEY = "FKJE_OJ6hA9qzdzrn2sbgJon2eLTa3atfAwuvsPY";//AK
	public static final String QiniuSECRET_KEY = "a9I5Q0UOR5SjK83rftG-Wt7T8W7Ng4kbsmNwzCIt";//SK

	//下载地址
	public static final String DEV_DOWNURL="http://192.168.0.42:8090/";    //dev
	public static final String SALE_DOWNURL="http://downloadgt.ove-ipark.com/";    //推广版
	public static final String PROD_DOWNURL="http://123.57.209.56:21112/";   //线上环境图片存放地址
	public static  String DOWNURL="";


	//融云id前缀
	public static final String DEV_RONG_ID_PREFIX="rong_dev_";    //dev
	public static final String SALE_RONG_ID_PREFIX="rong_sale_";    //推广版
	public static final String PROD_RONG_ID_PREFIX="rong_prod_";   //线上
	public static  String RONG_ID_PREFIX="";

	//图片上传绝对路径
	public static final String DEV_UPLOAD="/data/www/om_api/";    //dev
	public static final String SALE_UPLOAD="/data/www/15javadev_app_v3/gt/download/";    //推广版
	public static final String PROD_UPLOAD="/data/www/om_api/resource/";   //线上环境图片存放地址
	public static  String UPLOAD="";

	//index文件地址
	public static final String DEV_INDEX="/data/www/om_api/resource/appApk/index.html";    //dev
	public static final String SALE_INDEX="/data/www/15javadev_app_v3/gt/download/index.html";    //推广版
	public static final String PROD_INDEX="/data/www/om_api/resource/appApk/index.html";   //线上环境图片存放地址
	public static  String INDEX_URL="";

	//二维码生成地址
	public static final String DEV_QRCODE="/data/www/om_api/resource/QrCode/";    //dev
	public static final String SALE_QRCODE="/data/www/15javadev_app_v3/gt/download/QrCode/";    //推广版
	public static final String PROD_QRCODE="/data/www/om_api/resource/QrCode/";   //线上环境图片存放地址
	public static  String QRCODE_URL="";

	//极光推送
	private static final String ENV_DEV = "env=dev";//测试环境
	private static final String ENV_SALE = "env=sale";//销售推广环境
	private static final String ENV_PROD ="env=prod"; //生产环境
	public static  String ENV_TEST = "";

	//base_image_url 可使用条件编译动态赋值
	private static final String BASE_DEV_IMAGE_URL = "http://192.168.0.42:8090/";
	private static final String BASE_SALE_IMAGE_URL = "http://downloadgt.ove-ipark.com/";
	private static final String BASE_PROD_IMAGE_URL = "http://123.57.209.56:21112/";
	public static  String BASE_IMAGE_URL = "";

	//存储空间
	public static final String DEV_QiniuBucketName = "ovelec_app";
	public static final String SALE_QiniuBucketName = "ovelec_app";
	public static final String PROD_QiniuBucketName = "ovelec_gt";
	public static  String QiniuBucketName="";

	//url
	public static final String DEV_QiniuUrl = "http://seal.ovelec.com/";
	public static final String SALE_QiniuUrl = "http://seal.ovelec.com/";
	public static final String PROD_QiniuUrl = "http://gt.ovelec.com/";
	public static  String QiniuUrl ="";

	//七牛云文件前缀
	public static final String DEV_PREFIX = "dev/";
	public static final String SALE_PREFIX = "spread/";
	public static final String PROD_PREFIX = "";
	public static  String FILE_PREFIX ="";

	static{
		switch (PROFILES_ACTIVE){
				case "dev":
					DOWNURL=DEV_DOWNURL;
					UPLOAD=DEV_UPLOAD;
					INDEX_URL=DEV_INDEX;
					QRCODE_URL=DEV_QRCODE;
					ENV_TEST = ENV_DEV;
					BASE_IMAGE_URL = BASE_DEV_IMAGE_URL;
					QiniuBucketName=DEV_QiniuBucketName;
					QiniuUrl =DEV_QiniuUrl;
					FILE_PREFIX =DEV_PREFIX;
					RONG_ID_PREFIX=DEV_RONG_ID_PREFIX;
					RongAppKey=Dev_RongAppKey;
					RongAppSecret=Dev_RongAppSecret;
					break;
				case "sale":
					DOWNURL=SALE_DOWNURL;
					UPLOAD=SALE_UPLOAD;
					INDEX_URL=SALE_INDEX;
					QRCODE_URL=SALE_QRCODE;
					ENV_TEST = ENV_SALE;
					BASE_IMAGE_URL = BASE_SALE_IMAGE_URL;
					QiniuBucketName=SALE_QiniuBucketName;
					QiniuUrl =SALE_QiniuUrl;
					FILE_PREFIX =SALE_PREFIX;
					RONG_ID_PREFIX=SALE_RONG_ID_PREFIX;
					RongAppKey=Dev_RongAppKey;
					RongAppSecret=Dev_RongAppSecret;
					break;
				case "prod":
					DOWNURL=PROD_DOWNURL;
					UPLOAD=PROD_UPLOAD;
					INDEX_URL=PROD_INDEX;
					QRCODE_URL=PROD_QRCODE;
					ENV_TEST = ENV_PROD;
					BASE_IMAGE_URL = BASE_PROD_IMAGE_URL;
					QiniuBucketName=PROD_QiniuBucketName;
					QiniuUrl =PROD_QiniuUrl;
					FILE_PREFIX =PROD_PREFIX;
					RONG_ID_PREFIX=PROD_RONG_ID_PREFIX;
					RongAppKey=Prod_RongAppKey;
					RongAppSecret=Prod_RongAppSecret;
					break;
		}
	}

}
