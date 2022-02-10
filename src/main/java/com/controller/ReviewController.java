package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.QuestionDTO;
import com.dto.Rev_CommentDTO;
import com.dto.ReviewDTO;
import com.service.MemberService;
import com.service.R_CommentService;
import com.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService service;

	@Autowired
	R_CommentService rservice;

	@RequestMapping("/reviewList") // 후기 게시판 리스트
	public ModelAndView reviewList() {
		List<ReviewDTO> rlist = service.reviewList();

		System.out.println(rlist);

		ModelAndView mav = new ModelAndView();
		mav.addObject("reviewList", rlist);
		mav.setViewName("reviewList");

		return mav;
	}

	@RequestMapping("/reviewWriteAdd") // 후기 쓰기
	public String reviewWriteAdd(ReviewDTO rDTO) {
		service.reviewWriteAdd(rDTO);

		return "redirect:/reviewList";
	}

	@RequestMapping("/reviewReadContent") // 글 내용
	public ModelAndView reviewReadContent(@RequestParam("r_id") int r_id) {

		List<ReviewDTO> rlist = service.reviewReadContent(r_id);

		service.reviewLookupIncrease(r_id); // 조회수 증가

		List<Rev_CommentDTO> list = rservice.R_commentList(r_id);// 댓글 리스트
		System.out.println("list====" + list);

		System.out.println(rlist);
		ModelAndView mav = new ModelAndView();
		mav.addObject("reviewReadContent", rlist);
		mav.addObject("r_commentList", list);
		mav.setViewName("reviewReadContent");

		return mav;
	}

	@RequestMapping("/reviewContentDel") // 후기 내용 삭제
	public String reviewContentDel(int r_id) {
		System.out.println("r_id" + r_id);

		service.reviewContentDel(r_id);

		return "redirect:/reviewList";

	}

	@RequestMapping("/reviewUpdatePage") // 후기 내용 수정
	public ModelAndView reviewUpdatePage(@RequestParam("r_id") int r_id) {

		List<ReviewDTO> rlist = service.reviewReadContent(r_id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("reviewReadContent", rlist);
		mav.setViewName("reviewUpdatePage");

		return mav;
	}

	@RequestMapping("/reviewContentUpdateAction") // 후기 내용 수정 에서 리스트 보내기
	public String reviewContentUpdateAction(ReviewDTO rDTO) {
		System.out.println("==rDTO" + rDTO);

		service.reviewContentUp(rDTO);

		return "redirect:/reviewList";

	}

	// 게시물 추천 관련 메소드
	@RequestMapping("/recommend") // 추천 (좋아요)
	public String suggestionUpdate(@RequestParam int r_id) {
		System.out.println("recommend ========" + r_id);
		service.suggestionUpdate(r_id);

		return "redirect:/reviewList"; // 페이지값을 그대로 넘겨받기위해서 포워딩을 사용해 컨트롤러로 리턴시킨다.
	}

	@RequestMapping(value = "recommend", produces = "text/plain;charset=UTF-8") // 한글처리
	public @ResponseBody String recommend(@RequestParam("r_id") int r_id) {
		System.out.println("recommend ========" + r_id);
		service.suggestionUpdate(r_id);

		List<ReviewDTO> rlist = service.reviewReadContent(r_id);

		String mesg = "0";

		if (rlist.size() == 1)
			mesg = "" + rlist.get(0).getSuggestion();

		return mesg;
	}

	@RequestMapping("/badrecommend") // 추천 (싫어요)
	public String badsuggestionUpdate(@RequestParam int r_id) {
		System.out.println("badrecommend ========" + r_id);
		service.badsuggestionUpdate(r_id);

		return "redirect:/reviewList";
	}

	@RequestMapping(value = "badrecommend", produces = "text/plain;charset=UTF-8") // 한글처리
	public @ResponseBody String badrecommend(@RequestParam("r_id") int r_id) {
		System.out.println("badrecommend ========" + r_id);
		service.badsuggestionUpdate(r_id);

		List<ReviewDTO> rlist = service.reviewReadContent(r_id);

		String mesg = "0";

		if (rlist.size() == 1)
			mesg = "" + rlist.get(0).getBadsuggestion();

		return mesg; // view페이지가 아닌 mesg문자열 전송
	}
}
