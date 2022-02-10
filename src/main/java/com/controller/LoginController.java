package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;

import com.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService service;

	@RequestMapping(value = "/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		System.out.println(map);
		System.out.println("로그인 컨트");
		MemberDTO dto = service.login(map);
		System.out.println(dto);

		if (dto != null) {// 로그인 된 경우
			session.setAttribute("login", dto);
			session.setAttribute("userid", dto.getUserid());// dto로 받았으니 안 써도 됨

			String uri = (String) session.getAttribute("clickLink");

			if (uri != null) {
				System.out.println("uri===" + uri);

				if (uri.equals("/loginCheck/cartAdd")) {
					session.setAttribute("clickLink", ""); // ( , "") ""은 세션 삭제 /"clickLink"은 인터셉터에 있음
					return "redirect:/cartList";
				}
			}

			return "redirect:/productListAll";

		} else {// 로그인 안된경우
			model.addAttribute("mesg", "아이디 또는 비번이 잘못되었습니다.");
			return "loginForm";
		}
	}

	@RequestMapping(value = "/loginCheck/logout")
	public String logout(HttpSession session) {
		session.invalidate();// 로그인 세션 종료
		return "redirect:/";
	}
}
