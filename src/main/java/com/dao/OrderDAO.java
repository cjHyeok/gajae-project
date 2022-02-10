package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

@Repository
public class OrderDAO {

	@Autowired
	SqlSessionTemplate template;

	public CartDTO orderConfirmByNum(int c_id) {
		System.out.println("c_id====" + c_id);
		CartDTO dto = template.selectOne("OrderMapper.cartByNum", c_id);
		return dto;
	}

	public void orderAllDone(List<CartDTO> clist, MemberDTO mDTO) {
		int id = template.insert("OrderMapper.orderInsert", mDTO);

		ArrayList<OrderDTO> olist = new ArrayList<OrderDTO>();

		for (int i = 0; i < clist.size(); i++) {
			CartDTO cDto = clist.get(i);

			OrderDTO oDto = new OrderDTO();
			oDto.setOrdernum(mDTO.getOrdernum());
			oDto.setProdnum(cDto.getP_id());
			oDto.setQuantity(cDto.getQuantity());

			template.insert("OrderMapper.orderDetailInsert", oDto);
		}

	}

	public void orderDone(CartDTO cDTO, MemberDTO mDTO) {
		int id = template.insert("OrderMapper.orderInsert", mDTO);

		OrderDTO oDto = new OrderDTO();
		oDto.setOrdernum(mDTO.getOrdernum()); // ordernum keyProperty=
		oDto.setProdnum(cDTO.getP_id());
		oDto.setQuantity(cDTO.getQuantity());

		template.insert("OrderMapper.orderDetailInsert", oDto);

	}

	public void cartOrderDelete(int c_id) {
		int n = template.delete("OrderMapper.cartOrderDelete", c_id);
	}

	public List<CartDTO> cartList(MemberDTO dto) {
		List<CartDTO> list = template.selectList("OrderMapper.cartList", dto);
		return list;
	}

	public void delAllCart(MemberDTO mDTO) {
		int n = template.delete("OrderMapper.delAllCart", mDTO);

	}

}
