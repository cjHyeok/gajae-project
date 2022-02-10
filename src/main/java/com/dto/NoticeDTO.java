package com.dto;

import java.util.Date;

import lombok.Data;


@Data

public class NoticeDTO {

	private int n_id;
	private String n_title;
	private String username;
	private String userid;
	private Date wdate;
	private int lookup;
	private String content;

	
	
	
}
