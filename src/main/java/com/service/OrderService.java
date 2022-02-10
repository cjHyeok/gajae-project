package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDAO;
import com.dao.ProductDAO;
import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

@Service
public class OrderService {

	@Autowired
	OrderDAO dao;

	@Autowired
	ProductDAO pdao; // cartdao포함

	public CartDTO orderConfirmByNum(int c_id) {
		CartDTO dto = dao.orderConfirmByNum(c_id);
		return dto;
	}

	public void orderAllDone(List<CartDTO> clist, MemberDTO mDTO) {
		dao.orderAllDone(clist, mDTO); // 주문정보저장 insert
		dao.delAllCart(mDTO); // 카트에서 삭제 두 처리를 tx 처리함 root-context.xml에 //3번 // TODO Auto-generated method

	}

	public void orderDone(CartDTO cart, MemberDTO mDTO, int c_id) {
		dao.orderDone(cart, mDTO); // 주문정보저장 insert
		dao.cartOrderDelete(c_id); // 카트에서 삭제 두 처리를 tx 처리함 root-context.xml

	}

	public List<CartDTO> cartList(MemberDTO dto) {
		List<CartDTO> list = dao.cartList(dto);
		return list;
	}
}
