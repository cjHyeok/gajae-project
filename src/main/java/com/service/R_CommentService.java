package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.R_CommentDAO;
import com.dto.Rev_CommentDTO;

@Service
public class R_CommentService {

	@Autowired
	R_CommentDAO dao;

	public List<Rev_CommentDTO> R_commentList(int r_id) {
		List<Rev_CommentDTO> list = dao.R_commentList(r_id);
		return list;
	}

	public void R_commentWriteAdd(Rev_CommentDTO R_DTO) {
		dao.R_commentWriteAdd(R_DTO);

	}
}
