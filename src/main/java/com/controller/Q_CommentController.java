package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Que_CommentDTO;
import com.service.Q_CommentService;

@Controller
public class Q_CommentController {

	@Autowired
	Q_CommentService service;

	@RequestMapping("/Q_commentList") // 문의 댓글 리스트
	public ModelAndView Q_commentList(@RequestParam("id") int q_id) {

		List<Que_CommentDTO> list = service.Q_commentList(q_id);
		System.out.println(list);

		ModelAndView mav = new ModelAndView();
		mav.addObject("Q_commentList", list);
		mav.setViewName("Q_commentList");

		return mav;
	}

	@RequestMapping(value = "Q_commentWriteAdd", produces = "text/plain;charset=UTF-8") // 한글처리 댓글추가 문의 작성추가
	public @ResponseBody String recommend(@RequestParam("q_id") int q_id, @RequestParam("userid") String userid,
			@RequestParam("que_comment") String que_comment) {
		System.out.println("q_id, userid, que_comment" + q_id + " " + userid + "  " + que_comment);

		Que_CommentDTO q_DTO = new Que_CommentDTO();
		q_DTO.setQ_id(q_id);
		q_DTO.setUserid(userid);
		q_DTO.setComm_content(que_comment);

		service.Q_commentWriteAdd(q_DTO);
		List<Que_CommentDTO> list = service.Q_commentList(q_id);

		String retData = "0";

		retData = "<table boader= 0%>";
		for (int i = 0; i < list.size(); i++) {
			Que_CommentDTO qdto = list.get(i);

			retData += " <tr><td align='center'>";
			retData += qdto.getUsername();
			retData += "</td><td align='center'>";
			retData += qdto.getWdate();
			retData += "</td><td align='center'>";
			retData += qdto.getComm_content();
			retData += "</td></tr>";
		}
		retData += "</table>";

		System.out.println("retData=" + retData);

		return retData; // view페이지가 아닌 mesg문자열 전송
	}
}
