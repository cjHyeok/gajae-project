package com.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CartDTO {

	private int c_id;
	private String userid;
	private int p_id;
	private int quantity;
	private String p_name;
	private String p_option;
	private Date indate;
	private String p_photo;
	private int price;
}
