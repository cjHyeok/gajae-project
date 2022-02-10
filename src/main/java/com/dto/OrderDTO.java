package com.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {

	private int ordernum;
	private String userid;
	private String username;
	private Date odate;
	private String payment;
	private String qid; //쿠폰 아이디
	private int prodnum;
	private int quantity;
	private String p_name;
	private String p_photo;
	private String order_status;
	private int price;
	private String post;
	private String addr1;
	private String addr2;
	private String phone1;
	private String phone2;
	private String phone3;
}
