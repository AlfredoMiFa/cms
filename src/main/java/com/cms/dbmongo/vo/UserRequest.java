package com.cms.dbmongo.vo;

import com.cms.dbmongo.models.Role;

import lombok.Data;

@Data
public class UserRequest {
	
	String identity;
	String name;
	Role role;
	
}
