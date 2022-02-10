package com.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDTO {
	private int r_id;
	private String r_title;
	private String username;
	private Date wdate;
	private int lookup;
	private String userid;
	private String content;
	private int suggestion;
	private int badsuggestion;
}
