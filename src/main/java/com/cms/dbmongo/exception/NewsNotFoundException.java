package com.cms.dbmongo.exception;

import lombok.Getter;

public class NewsNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5979610871283675533L;
	@Getter
	private final String id;
	
	public NewsNotFoundException(String id) {
		this.id=id;
	}
	
}
