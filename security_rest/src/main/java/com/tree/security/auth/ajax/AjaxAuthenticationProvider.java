package com.tree.security.auth.ajax;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.tree.security.model.UserContext;
import com.tree.security.model.UserService;

/**
 * 
 * 
 *
 * Dic 29 2016
 */
@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
	
	private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");
        Assert.notNull(userService, "No implementation com.tree.security.model.UserService provided");
        
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserContext userContext = null;
	
        try {
			userContext = userService.validateUserContext(username, password);
		} catch (Exception e) {
			throw new AuthenticationServiceException(e.getMessage(),e);
		}		
        
        return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }
	

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    

}
