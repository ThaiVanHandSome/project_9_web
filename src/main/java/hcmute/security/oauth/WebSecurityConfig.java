//Lớp cấu hình bảo mật của ứng dụng Spring, định nghĩa cách xác thực, phân quyền và cấu hình bảo mật khác.
package hcmute.security.oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import hcmute.security.oauth.CustomOAuth2User;
import hcmute.security.oauth.CustomOAuth2UserService;
import hcmute.service.IUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	        .antMatchers("/", "/security/login", "/oauth/**").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
	            .loginPage("/security/login") // Set the custom login page
	            .loginProcessingUrl("/security/login") // Set the login processing URL
	            .usernameParameter("email")
	            .passwordParameter("pass")
	            .defaultSuccessUrl("/test") // Set the default success URL after login
	        .and()
	        .oauth2Login()
	            .loginPage("/security/login")
	            .userInfoEndpoint()
	                .userService(oauthUserService)
	            .and()
	            .successHandler(new AuthenticationSuccessHandler() {
	                
	                @Override
	                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	                        Authentication authentication) throws IOException, ServletException {
	                    System.out.println("AuthenticationSuccessHandler invoked");
	                    System.out.println("Authentication name: " + authentication.getName());
	                    CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
	                    
	                    userService.processOAuthPostLogin(oauthUser.getEmail(), null);
	                   
	                    response.sendRedirect("/admin/index");

	                }
	            })
	        .and()
	        .logout().logoutSuccessUrl("/").permitAll()
	        .and()
	        .exceptionHandling().accessDeniedPage("/403");
	}


	
	@Autowired
	private CustomOAuth2UserService oauthUserService;
	
	@Autowired
	private IUserService userService;
}
