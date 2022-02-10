package com.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Rev_CommentDTO {

	private int comm_id;
	private String userid;
	private String username;
	private String comm_content;
	private String wdate;
	private int r_id;
}
