package com.tree.security.model;

/**
 * 
 * UserService
 */
public interface UserService {
	
    public UserContext validateUserContext(String email, String password) throws Exception;
    
    
}
