package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.QuestionDAO;
import com.dto.NoticeDTO;
import com.dto.QuestionDTO;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO dao;

	public List<QuestionDTO> questionList() {
		List<QuestionDTO> qlist = dao.questionList();
		return qlist;
	}

	public List<QuestionDTO> questionReadContent(int q_id) {
		List<QuestionDTO> qlist = dao.questionReadContent(q_id);
		return qlist;
	}

	public void questionLookupIncrease(int q_id) {
		dao.questionLookupIncrease(q_id);

	}

	public void questionWriteAdd(QuestionDTO qDTO) {
		dao.questionWriteAdd(qDTO);

	}

	public void questionContentDel(int q_id) {
		dao.questionContentDel(q_id);

	}

	public void questionContentUp(QuestionDTO qDTO) {
		dao.questionContentUp(qDTO);

	}
}
