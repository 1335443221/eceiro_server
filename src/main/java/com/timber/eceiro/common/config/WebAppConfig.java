package com.timber.eceiro.common.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.timber.eceiro.common.Interceptor.SessionInterceptor;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

	/**
	 * 配置拦截器，阻止普通用户和游客进入管理员界面，阻止游客进行个人信息有关操作
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new SessionInterceptor())
			.addPathPatterns("/gtgx/**")
			.addPathPatterns("/manage/**")
			.addPathPatterns("/supervision/**")
			.excludePathPatterns("/gtgx/getQrCodeUrl")
			.excludePathPatterns("/gtgx/applogin")
			.excludePathPatterns("/gtgx/recordRongUserGroupData")
			.excludePathPatterns("/gtgx/recordRongUserToken")
			.excludePathPatterns("/gtgx/recordRongGroup")
			.excludePathPatterns("/gtgx/checkNoticeAuth")
			.excludePathPatterns("/gaoxin_app/api/v1/**")
			;
	}

}
