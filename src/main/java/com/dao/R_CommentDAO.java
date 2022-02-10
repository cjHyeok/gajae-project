package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Rev_CommentDTO;

@Repository
public class R_CommentDAO {
	
	@Autowired
	SqlSessionTemplate template;
	
	public List<Rev_CommentDTO> R_commentList(int r_id) {

		List<Rev_CommentDTO> qlist = template.selectList("R_CommentMapper.R_commentList", r_id);
		return qlist;
	}
	
	public void R_commentWriteAdd(Rev_CommentDTO R_DTO) {
		int n = template.insert("R_CommentMapper.R_commentWriteAdd", R_DTO);

	}
}
