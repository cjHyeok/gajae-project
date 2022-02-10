package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Not_CommentDTO;
import com.dto.Que_CommentDTO;

@Repository
public class N_CommentDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<Not_CommentDTO> N_commentList(int n_id) {
		List<Not_CommentDTO> qlist = template.selectList("N_CommentMapper.N_commentList", n_id);
		return qlist;
	}

	public void N_commentWriteAdd(Not_CommentDTO n_DTO) {
		int n = template.insert("N_CommentMapper.N_commentWriteAdd", n_DTO);

	}
}
