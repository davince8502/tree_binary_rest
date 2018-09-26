package com.tree.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.tree.business.service.impl.UserServiceImpl;
import com.tree.security.config.WebSecurityConfig;

@Configuration
@DependsOn("webSecurityConfig")
public class SecurityConfig {

	
	@Autowired
    public SecurityConfig(WebSecurityConfig webSecurityConfig, UserServiceImpl userService) throws Exception{
		webSecurityConfig.getAjaxAuthenticationProvider().setUserService(userService);
		
    }
	
}
