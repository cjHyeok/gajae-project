package com.dto;

import java.util.Date;

import lombok.Data;

@Data
public class QuestionDTO {

	private int q_id;
	private String q_title;
	private String username;
	private Date wdate;
	private int lookup;
	private String userid;
	private String content;
}
