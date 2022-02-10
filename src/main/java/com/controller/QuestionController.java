package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.NoticeDTO;
import com.dto.Que_CommentDTO;
import com.dto.QuestionDTO;
import com.dto.Rev_CommentDTO;
import com.service.Q_CommentService;
import com.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	@Autowired
	Q_CommentService qservice;
	
	@RequestMapping("/questionList")//질문 게시판 리스트
	public ModelAndView questionList() {
		
		List<QuestionDTO> qlist = service.questionList();
		System.out.println(qlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("questionList", qlist);
		mav.setViewName("questionList");

		return mav;
	}
	@RequestMapping("/questionReadContent")//질문 내용 보기
	public ModelAndView questionReadContent(@RequestParam("q_id") int q_id) {

		List<QuestionDTO> qlist = service.questionReadContent(q_id);

		service.questionLookupIncrease(q_id);

		List<Que_CommentDTO> list = qservice.Q_commentList(q_id); 
		
		System.out.println(qlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("questionReadContent", qlist);
		mav.addObject("q_commentList", list);
		mav.setViewName("questionReadContent");// main.jsp

		return mav;
	}

	@RequestMapping("/questionWriteAdd")//문의 작성
	public String questionWriteAdd(QuestionDTO qDTO) {
		service.questionWriteAdd(qDTO);

		return "redirect:/questionList";

	}
	
	@RequestMapping("/questionContentDel")//문의 내용 삭제
	public String questionContentDel(int q_id) {
		System.out.println("q_id"+ q_id);
				
		service.questionContentDel(q_id);
		
		return "redirect:/questionList";
		
	}
	
	@RequestMapping("/questionUpdatePage")//문의 내용 수정
	public ModelAndView questionUpdatePage(@RequestParam("q_id") int q_id) {

		List<QuestionDTO> qlist = service.questionReadContent(q_id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("questionReadContent", qlist);
		mav.setViewName("questionUpdatePage");

		return mav;
	}	
	
	
	@RequestMapping("/questionContentUpdateAction")//문의 내용 수정 보내기
	public String questionContentUpdateAction(QuestionDTO qDTO) {
			System.out.println("=====qDTO" + qDTO);
		
			service.questionContentUp(qDTO);

			return "redirect:/questList";

		}

}
