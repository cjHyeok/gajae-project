package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.NoticeDAO;
import com.dto.Not_CommentDTO;
import com.dto.NoticeDTO;
import com.service.N_CommentService;
import com.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	NoticeService service;

	@Autowired
	N_CommentService nservice;
	
	@RequestMapping("/noticeList")//공지 게시판 리스트
	public ModelAndView noticeList() {

		List<NoticeDTO> list = service.noticeList();
		System.out.println(list);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeList", list);
		mav.setViewName("noticeList");

		return mav;
	}

	@RequestMapping("/noticeReadContent") //공지 내용 읽기
	public ModelAndView noticeReadContent(@RequestParam("n_id") int n_id) {

		List<NoticeDTO> list = service.noticeReadContent(n_id);

		service.noticeLookupIncrease(n_id);
		
		List<Not_CommentDTO> nlist = nservice.N_commentList(n_id);
		System.out.println(list);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeReadContent", list);
		mav.addObject("n_commentList", nlist);
		mav.setViewName("noticeReadContent");

		return mav;
	}

	@RequestMapping("/noticeWriteAdd")//공지 게시판작성
	public String noticeWriteAdd(NoticeDTO nDTO) {
		service.noticeWriteAdd(nDTO);

		return "redirect:/noticeList";

	}
	
	@RequestMapping("/noticeContentDel")//공지 내용 삭제
	public String noticeContentDel(int n_id) {
		System.out.println("*** n_id"+ n_id);
		
		service.noticeContentDel(n_id);
		
		return "redirect:/noticeList";
		
	}
	
	@RequestMapping("/noticeUpdatePage")//공지 수정
	public ModelAndView noticeUpdatePage(@RequestParam("n_id") int n_id) {

		List<NoticeDTO> list = service.noticeReadContent(n_id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeReadContent", list);
		mav.setViewName("noticeUpdatePage");// main.jsp

		return mav;
	}	
	
	
	@RequestMapping("/noticeContentUpdateAction")//공지 수정눌렀을때 보내기
	public String noticeContentUpdateAction(NoticeDTO nDTO) {
			System.out.println("===========nDTO" + nDTO);
		
			service.noticeContentUp(nDTO);

			return "redirect:/noticeList";

		}

}
