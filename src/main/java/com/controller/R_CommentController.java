package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Rev_CommentDTO;
import com.service.R_CommentService;

@Controller
public class R_CommentController {

	@Autowired
	R_CommentService service;

	@RequestMapping("/R_commentList") // 후기 댓글 리스트
	public ModelAndView R_commentList(@RequestParam("id") int r_id) {

		List<Rev_CommentDTO> list = service.R_commentList(r_id);

		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("R_commentList", list);
		mav.setViewName("R_commentList");

		return mav;
	}

	@RequestMapping(value = "R_commentWriteAdd", produces = "text/plain;charset=UTF-8") // 한글처리 후기 댓글 내용 쓰기
	public @ResponseBody String recommend(@RequestParam("r_id") int r_id, @RequestParam("userid") String userid,
			@RequestParam("rev_comment") String rev_comment) {
		System.out.println("r_id, userid, rev_comment" + r_id + " " + userid + "  " + rev_comment);

		Rev_CommentDTO r_DTO = new Rev_CommentDTO();
		r_DTO.setR_id(r_id);
		r_DTO.setUserid(userid);
		r_DTO.setComm_content(rev_comment);

		service.R_commentWriteAdd(r_DTO);
		List<Rev_CommentDTO> list = service.R_commentList(r_id);

		String retData = "0";

		retData = "<table boader= 0%>";
		for (int i = 0; i < list.size(); i++) {
			Rev_CommentDTO rdto = list.get(i);

			retData += " <tr><td align='center'>";
			retData += rdto.getUsername();

			retData += "</td><td align='center'>";
			retData += rdto.getWdate();
			retData += "</td><td align='center'>";
			retData += rdto.getComm_content();
			retData += "</td></tr>";
		}
		retData += "</table>";

		System.out.println("retData=" + retData);

		return retData; // view페이지가 아닌 mesg문자열 전송
	}
}
