package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.NoticeDTO;

@Repository
public class NoticeDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<NoticeDTO> noticeList() {

		List<NoticeDTO> list = template.selectList("NoticeMapper.noticeList", 0);
		return list;
	}

	public List<NoticeDTO> noticeReadContent(int n_id) {
		List<NoticeDTO> list = template.selectList("NoticeMapper.noticeReadContent", n_id);
		return list;
	}

	public void noticeLookupIncrease(int n_id) {
		template.update("NoticeMapper.noticeLookupIncrease", n_id);
	}

	public void noticeWriteAdd(NoticeDTO nDTO) {
		int n = template.insert("NoticeMapper.noticeWriteAdd", nDTO);

	}

	public void noticeContentDel(int n_id) {
		int n = template.insert("NoticeMapper.noticeContentDel", n_id);
	}

	public void noticeContentUp(NoticeDTO nDTO) {
		template.update("NoticeMapper.noticeContentUp", nDTO);

	}

}
