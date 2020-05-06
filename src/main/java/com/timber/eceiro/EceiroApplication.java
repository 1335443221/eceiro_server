package com.timber.eceiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration//(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties
@EnableScheduling //开启定时器
@MapperScan({"com.sl.gtgx.dao"})
public class EceiroApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EceiroApplication.class, args);
	}
	
	@Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

	@Bean	
	public EmbeddedServletContainerCustomizer containerCustomizer() {
			return new EmbeddedServletContainerCustomizer() {
				@Override
				public void customize(ConfigurableEmbeddedServletContainer container) {				
				}
			};
		}

}
