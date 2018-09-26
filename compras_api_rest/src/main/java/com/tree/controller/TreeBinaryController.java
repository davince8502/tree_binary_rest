package com.tree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tree.business.service.ITreeBinaryService;
import com.tree.commons.emuns.ErrorCodeEnum;
import com.tree.commons.exception.ValidationException;
import com.tree.domain.dto.ArbolDto;
import com.tree.domain.dto.ResponseServiceDTO;
import com.tree.domain.model.Arbol;
import com.tree.domain.model.Nodo;


/**
 * Controlador REST encargado de administrar las peticiones sobre los arboles binarios . 
 * 
 * @author 	MHernandez <br>
 * @date 23/09/2018
 * @version 1.0
 */

@RestController
public class TreeBinaryController  extends AbstratcController{
	
	@Autowired
	private ITreeBinaryService treeBinaryService;
	

	
	@RequestMapping(value = "/auth/arbol/create", method=RequestMethod.POST, produces={ MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResponseServiceDTO> crearArbol(@RequestBody ArbolDto arbol) {
		
		ResponseServiceDTO respuesta = new ResponseServiceDTO();
		
		try {
		 	try {
				
		 		this.validarEntidad(arbol, respuesta);		
		 		
		 		Arbol arbol_new = new Arbol();
		 		arbol_new.setIdentificador(treeBinaryService.getMaxIdArbol()+1);
		 		
		 		for ( Integer value : arbol.getValues()) {
	 				arbol_new.addNodo(new Nodo(value));
				}
		 		
		 		boolean result = treeBinaryService.createTreeInCache(arbol_new);
		 		
		 		if(result) {
		 			arbol_new = treeBinaryService.getTreeForkey(arbol_new.getIdentificador());
		 			
		 			respuesta.setData(arbol_new);
					respuesta.setResponseCode(ErrorCodeEnum.OK.getCode());
		 		}
		 		else {
					respuesta.setResponseCode(ErrorCodeEnum.ERROR_CREANDO_ARBOL.getCode());
		 		}
		 			
			}catch (ValidationException e) {
				return obtenerRespuestaFromValidateException(e, respuesta);
			}
	 	
		}catch (Exception e) {			
			this.obtenerRespuestaErrorGeneral(e, respuesta);
		}	
	 	return new ResponseEntity<ResponseServiceDTO>(respuesta, HttpStatus.OK);
    }
	
	
	
	@RequestMapping(value = "/auth/arbol/addNodos", method=RequestMethod.POST, produces={ MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResponseServiceDTO> addNodos(@RequestBody ArbolDto arbol) {
		
		ResponseServiceDTO respuesta = new ResponseServiceDTO();
		
		try {
		 	try {
				
		 		this.validarEntidad(arbol, respuesta);		
		 		
		 		if(arbol.getId() != null) {		 		
		 	
			 		Arbol arb = treeBinaryService.getTreeForkey(arbol.getId());
			 		
			 		if(arb != null) {
			 		
				 		for ( Integer value : arbol.getValues()) {
				 			arb.addNodo(new Nodo(value));
						}
				 		treeBinaryService.updateArbol(arb);
				 		
				 	
			 			respuesta.setData(arb);
						respuesta.setResponseCode(ErrorCodeEnum.OK.getCode());		
						
			 		}else {
			 			respuesta.setResponseCode(ErrorCodeEnum.ERROR_ARBOL_NO_EXISTE.getCode());	
			 		}
			 		
		 		}else{
		 			respuesta.setResponseCode(ErrorCodeEnum.ERROR_ID_ARBOL_INVALIDO.getCode());				
		 		}	 		
		 			
			}catch (ValidationException e) {
				return obtenerRespuestaFromValidateException(e, respuesta);
			}
	 	
		}catch (Exception e) {			
			this.obtenerRespuestaErrorGeneral(e, respuesta);
		}	
	 	return new ResponseEntity<ResponseServiceDTO>(respuesta, HttpStatus.OK);
    }
	
	

}
