package com.cms.dbmongo.exception;

import lombok.Getter;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5327935208633114857L;
	
	@Getter
	private final String id;
	
	public UserNotFoundException(String id) {
		this.id=id;
	}
	
}
