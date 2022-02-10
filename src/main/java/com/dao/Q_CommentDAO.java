package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Que_CommentDTO;

@Repository
public class Q_CommentDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<Que_CommentDTO> Q_commentList(int q_id) {

		List<Que_CommentDTO> qlist = template.selectList("Q_CommentMapper.Q_commentList", q_id);
		return qlist;
	}

	public void Q_commentWriteAdd(Que_CommentDTO Q_DTO) {
		int n = template.insert("Q_CommentMapper.Q_commentWriteAdd", Q_DTO);

	}
}
