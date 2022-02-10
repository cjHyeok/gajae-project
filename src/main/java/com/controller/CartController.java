package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;


@Controller
public class CartController {

	@Autowired
	CartService service;
	

	
	@RequestMapping("/loginCheck/cartAdd")//카트에 추가
	public String cartAdd(CartDTO cart, HttpSession session) {
				
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		cart.setUserid(mDTO.getUserid());
		service.cartAdd(cart);
		
		return "redirect:../cartList";
	}
	
	@RequestMapping("/cartList")//장바구니
	public ModelAndView cartList(RedirectAttributes attr, HttpSession session) {
		MemberDTO dto= (MemberDTO)session.getAttribute("login");
		String userid=dto.getUserid();
		System.out.println("userid ===="+ userid);
		List<CartDTO> list =service.cartList(dto);
		System.out.println("cartList===" + list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartList", list);
		mav.setViewName("cartList");
		
		return mav;
		
	}
	         
	
	@RequestMapping(value="/loginCheck/cartDelete")//장바구니에서 삭제
	public @ResponseBody void cartDelte(@RequestParam("c_id") int c_id) {
		System.out.println("c_id123123"+c_id);
		service.cartDelete(c_id);//삭제 갯수 출력
	}
	
	@RequestMapping(value = "/loginCheck/delAllCart")//장바구니에서 전체삭제
	public String delAllCart(@RequestParam("check") ArrayList<String> list) {
		System.out.println(list);
		service.delSelCart(list); //삭제 갯수 출력 
		
		return "redirect:../cartList";   //카트리스트 다시 읽어오기 
	}
	
	@RequestMapping(value = "/loginCheck/delSelCart")//장바구니에서 선택삭제
	public String delSelCart(@RequestParam("check") ArrayList<String> list) {
		System.out.println(list);
		service.delSelCart(list); //삭제 
		
		return "redirect:../cartList";   //카트리스트 다시 읽어오기 
	}
	
	@RequestMapping(value = "/loginCheck/cartUpdate")//장바구니 수정
	@ResponseBody
	public void cartUpdate(@RequestParam Map<String, String>map) {
		System.out.println(map);
		service.cartUpdate(map);
	}
}
