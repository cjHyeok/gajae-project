package com.dto;
import java.util.Date;
import lombok.Data;

@Data
public class Que_CommentDTO {

	private int q_comm_id;
	private String userid;
	private String username;
	private String comm_content;
	private String wdate;
	private int q_id;
	
}
