package com.tree.domain.dto;

import java.util.List;

import com.tree.commons.anotations.FieldValidate;

public class ArbolDto {
	
	private Integer Id;
	@FieldValidate(required = true)
	private List<Integer> values;
	private Boolean isNew;
	private Boolean finish;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public List<Integer> getValues() {
		return values;
	}
	public void setValues(List<Integer> values) {
		this.values = values;
	}
	public Boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
	public Boolean getFinish() {
		return finish;
	}
	public void setFinish(Boolean finish) {
		this.finish = finish;
	}
	

}
