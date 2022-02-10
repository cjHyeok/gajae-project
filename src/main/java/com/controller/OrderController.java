package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.OrderService;
import com.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	MemberService mService;

	@Autowired
	ProductService pService;

	@Autowired
	OrderService oService;

	@RequestMapping("/loginCheck/orderConfirm") // 주문하기
	public String orderConfirm(@RequestParam("c_id") int c_id, HttpSession session, RedirectAttributes xxx) {
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		String userid = mDTO.getUserid();
		mDTO = mService.myPage(userid);

		CartDTO cart = oService.orderConfirmByNum(c_id); // 장바구니 정보가져오기
		System.out.println("cart--" + cart);
		xxx.addFlashAttribute("mDTO", mDTO); // request에 회원정보저장
		xxx.addFlashAttribute("cDTO", cart); // request에 카트정보저장
		xxx.addFlashAttribute("c_id", c_id);

		return "redirect:../orderConfirm"; 
	}

	@RequestMapping(value = "/loginCheck/orderDone", produces = "text/plain;charset=UTF-8")
	public String orderDone(int c_id, HttpSession session, RedirectAttributes xxx) {
		// System.out.println("cDTO"+cDTO);
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		// System.out.println("oDTO"+oDTO);
		
		CartDTO cart = oService.orderConfirmByNum(c_id); // 장바구니 정보가져오기
		
		oService.orderDone(cart, mDTO, c_id);

		xxx.addFlashAttribute("mDTO", mDTO); // request에 회원정보저장

		xxx.addFlashAttribute("cDTO", cart); // request에 카트정보저장
		
		return "redirect:../orderDone";
	}

	@RequestMapping("/loginCheck/orderAllConfirm") // 오더 전체 주문하기
	public String orderAllConfirm(HttpSession session, RedirectAttributes xxx) {
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		String userid = mDTO.getUserid();
		mDTO = mService.myPage(userid); // 사용자 정보 가져오기

		List<CartDTO> clist = oService.cartList(mDTO);
		xxx.addFlashAttribute("cList", clist);
		xxx.addFlashAttribute("mDTO", mDTO); // request에 회원정보저장
		
		return "redirect:../orderAllConfirm"; 

	}

	@RequestMapping("/loginCheck/orderAllDone") // 전체 주문확인
	public String orderAllDone(HttpSession session, RedirectAttributes xxx) {
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		String userid = mDTO.getUserid();
		mDTO = mService.myPage(userid); // 사용자 정보 가져오기

		List<CartDTO> clist = oService.cartList(mDTO);
		oService.orderAllDone(clist, mDTO);
		xxx.addFlashAttribute("cList", clist);
		xxx.addFlashAttribute("mDTO", mDTO); 
		
		return "redirect:../orderAllDone";
	}
}
