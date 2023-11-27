package vn.iostar.ajax;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import vn.iostar.ajax.*;

import vn.iostar.ajax.Config.*;
import vn.iostar.ajax.Service.*;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class AjaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjaxApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IStorageService storageService) {
		return (args -> {
			storageService.init();
		});
	}

	public FilterRegistrationBean<CustomSiteMeshFilter> siteMeshFilter() {

		FilterRegistrationBean<CustomSiteMeshFilter> filterRegistrationBean = new FilterRegistrationBean<CustomSiteMeshFilter>();

		filterRegistrationBean.setFilter(new CustomSiteMeshFilter()); // adding sitemesh filter ??

		filterRegistrationBean.addUrlPatterns("/*");

		return filterRegistrationBean;
	}

}
