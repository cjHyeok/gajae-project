package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Q_CommentDAO;
import com.dto.Que_CommentDTO;

@Service
public class Q_CommentService {

	@Autowired
	Q_CommentDAO dao;

	public List<Que_CommentDTO> Q_commentList(int q_id) {
		List<Que_CommentDTO> list = dao.Q_commentList(q_id);
		return list;
	}

	public void Q_commentWriteAdd(Que_CommentDTO Q_DTO) {
		dao.Q_commentWriteAdd(Q_DTO);

	}
}
