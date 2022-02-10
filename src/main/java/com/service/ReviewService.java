package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReviewDAO;
import com.dto.QuestionDTO;
import com.dto.ReviewDTO;

@Service
public class ReviewService {
	
	@Autowired
	ReviewDAO dao;
	
	public List<ReviewDTO> reviewList(){
		List<ReviewDTO> rlist = dao.reviewList();
		return rlist;
	}

	public void reviewWriteAdd(ReviewDTO rDTO) {
		dao.reviewWriteAdd(rDTO);
	}

	public List<ReviewDTO> reviewReadContent(int r_id) {
		List<ReviewDTO> rlist = dao.reviewReadContent(r_id);
		return rlist;
	}
	
	public void reviewLookupIncrease(int r_id) {
		dao.reviewLookupIncrease(r_id);

	}

	public void reviewContentDel(int r_id) {
		dao.reviewContentDel(r_id);
		
	}

	public void reviewContentUp(ReviewDTO rDTO) {
		dao.reviewContentUp(rDTO);
	}
	
	public void suggestionUpdate(int r_id) {
		dao.suggestionUpdate(r_id);
	}
	
	
	  public void badsuggestionUpdate(int r_id) {
	  dao.badsuggestionUpdate(r_id); }
	 
}
