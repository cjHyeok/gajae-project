package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.N_CommentDAO;
import com.dto.Not_CommentDTO;
import com.dto.Que_CommentDTO;

@Service
public class N_CommentService {

	@Autowired
	N_CommentDAO dao;

	public List<Not_CommentDTO> N_commentList(int n_id) {
		List<Not_CommentDTO> list = dao.N_commentList(n_id);
		return list;
	}

	public void N_commentWriteAdd(Not_CommentDTO N_DTO) {
		dao.N_commentWriteAdd(N_DTO);

	}
}
