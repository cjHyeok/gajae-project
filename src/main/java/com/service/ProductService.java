package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDAO;
import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.dto.ProductDTO;

@Service
public class ProductService {

	@Autowired
	ProductDAO dao;

	public List<ProductDTO> productList(String p_catecode) {
		List<ProductDTO> plist = dao.productList(p_catecode);
		return plist;
	}

	public List<ProductDTO> productListAll() {
		List<ProductDTO> plist = dao.productListAll();
		return plist;
	}

	public ProductDTO productRetrieve(Map<String, String> map) {
		ProductDTO dto = dao.productRetrieve(map);
		return dto;
	}

}
