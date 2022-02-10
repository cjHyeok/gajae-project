package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.MemberDTO;

@Repository
public class CartDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<CartDTO> cartList(MemberDTO dto) {
		System.out.println("userid---2222" + dto);
		List<CartDTO> list = template.selectList("CartMapper.cartList", dto);
		return list;
	}

	public void cartAdd(CartDTO cart) {
		// TODO Auto-generated method stub
		template.insert("CartMapper.cartAdd", cart);

	}

	public void cartDelete(int c_id) {
		int n = template.delete("CartMapper.cartDelete", c_id);
	}

	public void delAllCart(ArrayList<String> list) {
		int n = template.delete("CartMapper.delAllCart", list);
	}

	public void delSelCart(ArrayList<String> list) {
		int n = template.delete("CartMapper.delSelCart", list);
	}

	public void cartUpdate(Map<String, String> map) {
		int n = template.update("CartMapper.cartUpdate", map);

	}
}
