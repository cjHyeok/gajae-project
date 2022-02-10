package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Not_CommentDTO;
import com.dto.Que_CommentDTO;
import com.service.N_CommentService;

@Controller
public class N_CommentController {

	@Autowired
	N_CommentService service;

	@RequestMapping("/N_commentList") // notice공지 코멘트 리스트
	public ModelAndView N_commentList(@RequestParam("id") int n_id) {

		List<Not_CommentDTO> list = service.N_commentList(n_id);

		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("N_commentList", list);
		mav.setViewName("N_commentList");

		return mav;
	}

	@RequestMapping(value = "N_commentWriteAdd", produces = "text/plain;charset=UTF-8") // 한글처리 코멘트 작성
	public @ResponseBody String recommend(@RequestParam("n_id") int n_id, @RequestParam("userid") String userid,
			@RequestParam("not_comment") String not_comment) {

		System.out.println("n_id, userid, not_comment====" + n_id + " " + userid + "  " + not_comment);

		Not_CommentDTO n_DTO = new Not_CommentDTO();
		n_DTO.setN_id(n_id);
		n_DTO.setUserid(userid);
		n_DTO.setComm_content(not_comment);

		service.N_commentWriteAdd(n_DTO);
		List<Not_CommentDTO> list = service.N_commentList(n_id);

		System.out.println("list123" + list);
		String retData = "0";

		retData = "<table boader= 0%>";
		for (int i = 0; i < list.size(); i++) {
			Not_CommentDTO qdto = list.get(i);

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

		return retData;
	}
}