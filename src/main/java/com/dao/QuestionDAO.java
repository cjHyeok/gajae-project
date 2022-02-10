package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.NoticeDTO;
import com.dto.QuestionDTO;

@Repository
public class QuestionDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<QuestionDTO> questionList() {

		List<QuestionDTO> qlist = template.selectList("QuestionMapper.questionList", 0);
		return qlist;
	}

	public List<QuestionDTO> questionReadContent(int q_id) {
		List<QuestionDTO> qlist = template.selectList("QuestionMapper.questionReadContent", q_id);
		return qlist;
	}

	public void questionLookupIncrease(int q_id) {
		// TODO Auto-generated method stub
		template.update("QuestionMapper.questionLookupIncrease", q_id);
	}

	public void questionWriteAdd(QuestionDTO qDTO) {
		// TODO Auto-generated method stub
		int n = template.insert("QuestionMapper.questionWriteAdd", qDTO);
	}

	public void questionContentDel(int q_id) {
		// TODO Auto-generated method stub
		int n = template.insert("QuestionMapper.questionContentDel", q_id);
	}

	public void questionContentUp(QuestionDTO qDTO) {
		// TODO Auto-generated method stub
		template.update("QuestionMapper.questionContentUp", qDTO);
	}

}
