package com.cms.dbmongo.exception;

import lombok.Getter;

public class CategoryNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 116580233372233922L;
	@Getter
	private final String id;
	
	public CategoryNotFoundException(String id) {
		this.id=id;
	}
	
}
