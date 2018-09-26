package com.tree.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tree.business.service.IUserService;
import com.tree.commons.emuns.ErrorCodeEnum;
import com.tree.commons.exception.ValidationException;
import com.tree.commons.util.ConfigProperties;
import com.tree.domain.dto.ResponseServiceDTO;
import com.tree.domain.model.Usuario;
import com.tree.security.config.WebSecurityConfig;
import com.tree.security.model.UserContext;
import com.tree.security.model.token.AccessJwtToken;
import com.tree.security.model.token.JwtTokenFactory;


/**
 * Controlador REST encargado de administrar las peticiones de acceso al sistema al sistema . 
 * 
 * @author 	MHernandez <br>
 * @date 22/09/2018
 * @version 1.0
 */

@RestController
public class LoginController  extends AbstratcController{
	
	private static final String USER_NAME = "user.name";
	private static final String USER_EMAIL= "user.email";
	
	
	@Autowired
	private JwtTokenFactory tokenFactory;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ConfigProperties configProperties;
	

	
	@RequestMapping(value = WebSecurityConfig.FORM_BASED_LOGIN_ENTRY_POINT, method=RequestMethod.POST, produces={ MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResponseServiceDTO> loginUser(@RequestBody Usuario usuario) {
		
		ResponseServiceDTO respuesta = new ResponseServiceDTO();
		
		try {
		 	try {
	
				UserContext userContext = userService.validateUserContext(usuario.getEmail(), usuario.getPassword());
	
				AccessJwtToken accessToken = tokenFactory.createAccessJwtToken(userContext);
				
				usuario.setPassword(null);
				usuario.setEmail(configProperties.getPropiedad(USER_EMAIL));
				usuario.setUsername(configProperties.getPropiedad(USER_NAME));
				usuario.setId( (Integer) userContext.getDataUser());
				
				
				Map<String, Object> resultMap = new HashMap<>();
				resultMap.put("accessToken", accessToken);
				resultMap.put("user", usuario);
	
				respuesta.setData(resultMap);
				respuesta.setResponseCode(ErrorCodeEnum.OK.getCode());
		    	
			}catch (ValidationException e) {
				return obtenerRespuestaFromValidateException(e, respuesta);
			}
	 	
		}catch (Exception e) {			
			this.obtenerRespuestaErrorGeneral(e, respuesta);
		}	
	 	return new ResponseEntity<ResponseServiceDTO>(respuesta, HttpStatus.OK);
    }
	
	

}
