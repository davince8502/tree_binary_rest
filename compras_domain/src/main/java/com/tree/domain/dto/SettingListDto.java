package com.tree.domain.dto;

public class SettingListDto {
	

	private String nombre;

	private String codigo;
	
	public SettingListDto() {
	}
	
	public SettingListDto(String codigo, String nombre) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
