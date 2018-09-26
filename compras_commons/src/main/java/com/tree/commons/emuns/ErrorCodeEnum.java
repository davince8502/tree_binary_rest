package com.tree.commons.emuns;

/**
 * Enum que contiene los códigos de error manejados en las validaciones. 
 * 
 * @author 	MHernandez <br>
 * @date 03 de Dicimbre de 2017
 * @version 1.0
 */

public enum ErrorCodeEnum {
	
	OK("000000"),
    GENERAL_ERROR("ERR000"),
    
    USER_NO_FOUND("AUTH01"),
	BAD_PASSWORD("AUTH02"),
	CLAVE_NUEVA_IGUAL("AUTH03"),
	SIN_ROLES("AUTH04"),
	
	
	ERROR_CREANDO_ARBOL("ERR001"),
	ERROR_ID_ARBOL_INVALIDO("ERR002"),

	ERROR_ARBOL_NO_EXISTE("ERR003"),
    
    CAMPOS_INVALIDOS("DATA00");
	
    private String code;

    private ErrorCodeEnum(String code) {
        this.code = code;
    }

   
    public String getCode() {
        return code;
    }

}
