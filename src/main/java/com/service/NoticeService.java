package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.NoticeDAO;
import com.dto.NoticeDTO;

@Service
public class NoticeService {

	@Autowired
	NoticeDAO dao;

	public List<NoticeDTO> noticeList() {
		List<NoticeDTO> list = dao.noticeList();
		return list;
	}

	public List<NoticeDTO> noticeReadContent(int n_id) {
		List<NoticeDTO> list = dao.noticeReadContent(n_id);
		return list;
	}

	public void noticeLookupIncrease(int n_id) {
		dao.noticeLookupIncrease(n_id);

	}

	public void noticeWriteAdd(NoticeDTO nDTO) {
		dao.noticeWriteAdd(nDTO);

	}

	public void noticeContentDel(int n_id) {
		dao.noticeContentDel(n_id);

	}

	public void noticeContentUp(NoticeDTO nDTO) {
		dao.noticeContentUp(nDTO);

	}

}
