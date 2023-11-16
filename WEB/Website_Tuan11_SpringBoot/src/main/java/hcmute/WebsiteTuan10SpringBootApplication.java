package hcmute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import hcmute.config.CustomSiteMeshFilter;


@SpringBootApplication
public class WebsiteTuan10SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteTuan10SpringBootApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<CustomSiteMeshFilter> siteMeshFilter() {
	FilterRegistrationBean<CustomSiteMeshFilter> filterRegistrationBean = new FilterRegistrationBean<CustomSiteMeshFilter>();
	filterRegistrationBean.setFilter(new CustomSiteMeshFilter()); // adding sitemesh filter ??
	filterRegistrationBean.addUrlPatterns("/*");
	return filterRegistrationBean;
	}
}
