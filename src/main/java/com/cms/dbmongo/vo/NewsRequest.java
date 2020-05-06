package com.cms.dbmongo.vo;

import java.util.Set;

import com.cms.dbmongo.models.Category;
import com.cms.dbmongo.models.Tag;

import lombok.Data;

@Data
public class NewsRequest {
	
	String title;
	String content;
	
	Set<Category> categories;
	Set<Tag> tags;
	
}
