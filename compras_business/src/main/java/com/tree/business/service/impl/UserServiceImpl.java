package com.tree.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tree.business.service.IUserService;
import com.tree.commons.emuns.ErrorCodeEnum;
import com.tree.commons.exception.ValidationException;
import com.tree.commons.util.ConfigProperties;
import com.tree.security.model.UserContext;


/**
 * implementación del servicio {@link IUserService} para el menejo de lógica de Usuarios. 
 * 
 * @author 	MHernandez <br>
 * @date 22/09/2018
 * @version 1.0
 */

@Service

public class UserServiceImpl implements IUserService {
	
	private static final String USER_PASS = "user.password";	
	private static final String USER_NAME = "user.name";
	private static final String USER_EMAIL= "user.email";
	
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @Autowired
    private ConfigProperties configProperties;
    

	@Override
	public UserContext validateUserContext(String email, String password) throws ValidationException {
  	 
		 
		 if (StringUtils.isEmpty(email) || (StringUtils.isNotBlank(email) 
				 && !StringUtils.equals(email, configProperties.getPropiedad(USER_EMAIL)))) {
			throw new ValidationException(ErrorCodeEnum.USER_NO_FOUND);
		 }
		
		if (!encoder.matches(password, configProperties.getPropiedad(USER_PASS))) {
			throw new ValidationException(ErrorCodeEnum.BAD_PASSWORD);
		}
		
		List<GrantedAuthority> authorities = new ArrayList();		
		authorities.add(new SimpleGrantedAuthority("ADMIN"));

		UserContext userContext = UserContext.create(configProperties.getPropiedad(USER_NAME), authorities, 1);	
		

		return userContext;
	}
    

	

	
    
}
