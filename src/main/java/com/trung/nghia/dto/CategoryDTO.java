package com.trung.nghia.dto;

import com.trung.nghia.model.AbstractModel;

public class CategoryDTO extends AbstractModel<CategoryDTO> {
	private String  name ;
	private String code ;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
