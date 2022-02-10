package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;

	@RequestMapping(value = "/memberAdd") // 회원가입
	public String memberAdd(MemberDTO m, Model model) {
		service.memberAdd(m);

		model.addAttribute("success", "회원가입성공"); // model에 데이터 담기
		return "main";
	}

	@RequestMapping(value = "/loginCheck/myPage") // 마이페이지
	public String myPage(HttpSession session) {

		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String userid = dto.getUserid(); // 세션에서 useridid 얻기
		dto = service.myPage(userid);
		System.out.println(dto);
		session.setAttribute("login", dto);
		
		return "redirect:../myPage"; 
		
	}

	@RequestMapping(value = "/idDuplicateCheck", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String idDuplicatedCheck(@RequestParam("id") String userid) {// 아이디 중복검사
		MemberDTO dto = service.myPage(userid);
		System.out.println("idDuplicatedCheck====   " + userid);
		String mesg = "아이디 사용가능";
		if (dto != null) {
			mesg = "아이디 중복";
		}
		return mesg;
	}

	@RequestMapping(value = "/loginCheck/memberUpdate")
	public String memberUpdate(MemberDTO m) {// 회원정보수정
		service.memberUpdate(m);
		
		return "redirect:../loginCheck/myPage";
	}
}
