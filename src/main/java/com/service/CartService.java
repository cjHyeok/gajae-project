package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dao.ProductDAO;
import com.dto.CartDTO;
import com.dto.MemberDTO;

@Service
public class CartService {

	@Autowired
	CartDAO dao;

	public List<CartDTO> cartList(MemberDTO dto) {
		List<CartDTO> list = dao.cartList(dto);
		return list;
	}

	public void cartAdd(CartDTO cart) {
		dao.cartAdd(cart);
	}

	public void cartDelete(int c_id) {
		dao.cartDelete(c_id);
	}

	public void delAllCart(ArrayList<String> list) {
		dao.delAllCart(list);
	}

	public void delSelCart(ArrayList<String> list) {
		dao.delSelCart(list);
	}

	public void cartUpdate(Map<String, String> map) {
		dao.cartUpdate(map);
	}
}
