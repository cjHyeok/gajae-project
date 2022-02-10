package com.dto;

import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;


@Data
public class ProductDTO {

	private int p_id;
	private String p_name;
	private String p_catecode;
	private int cost;
	private int price;
	private String p_option;
	private String p_description;
	private String p_photo;
	private String salesyn;
	private Date regdate;
	
	
	
}
