package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ReviewDTO;

@Repository
public class ReviewDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<ReviewDTO> reviewList() {
		List<ReviewDTO> rlist = template.selectList("ReviewMapper.reviewList", 0);
		return rlist;
	}

	public void reviewWriteAdd(ReviewDTO rDTO) {
		int n = template.insert("ReviewMapper.reviewWriteAdd", rDTO);
	}

	public void reviewLookupIncrease(int r_id) {
		template.update("ReviewMapper.reviewLookupIncrease", r_id);

	}

	public List<ReviewDTO> reviewReadContent(int r_id) {
		List<ReviewDTO> rlist = template.selectList("ReviewMapper.reviewReadContent", r_id);
		return rlist;
	}

	public void reviewContentDel(int r_id) {
		int n = template.insert("ReviewMapper.reviewContentDel", r_id);
	}

	public void reviewContentUp(ReviewDTO rDTO) {
		template.update("ReviewMapper.reviewContentUp", rDTO);
	}

	public void suggestionUpdate(int r_id) {
		template.update("ReviewMapper.suggestionUpdate", r_id);

	}

	public void badsuggestionUpdate(int r_id) {
		template.update("ReviewMapper.badsuggestionUpdate", r_id);

	}

}
