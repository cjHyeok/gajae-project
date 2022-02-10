package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.dto.ProductDTO;
import com.service.MemberService;
import com.service.OrderService;
import com.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;

	@Autowired
	MemberService mservice;

	@Autowired
	OrderService oservice;

	@RequestMapping("/productList") // 상품리스트
	public ModelAndView productList(@RequestParam("p_catecode") String p_catecode) {
		System.out.println("p_cat=======" + p_catecode);
		if (p_catecode == null) {
			p_catecode = "사과";
		}
		System.out.println("p_cat======111111=" + p_catecode);

		List<ProductDTO> plist = service.productList(p_catecode);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", plist);
		mav.setViewName("main");

		return mav;

	}

	@RequestMapping(value = "/") // 메인
	public ModelAndView main(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		List<ProductDTO> plist = service.productListAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", plist);
		mav.setViewName("main");

		return mav;
	}

	@RequestMapping("/productListAll") // 메인에서 상품 리스트 뜨도록 만들어주기
	public ModelAndView productListAll() {

		List<ProductDTO> plist = service.productListAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", plist);
		mav.setViewName("main");

		return mav;

	}

	@RequestMapping("/productRetrieve") // 상품 상세페이지
	@ModelAttribute("productRetrieve")
	public ProductDTO productRetrieve(@RequestParam Map<String, String> map) {
		ProductDTO dto = service.productRetrieve(map);

		return dto;
	}

}
