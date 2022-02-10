package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.dto.ProductDTO;

@Repository
public class ProductDAO {
	@Autowired
	SqlSessionTemplate template;

	public List<ProductDTO> productList(String p_catecode) {

		List<ProductDTO> plist = template.selectList("ProductMapper.productList", p_catecode);
		return plist;
	}

	public List<ProductDTO> productListAll() {

		List<ProductDTO> plist = template.selectList("ProductMapper.productListAll", "0");
		return plist;
	}

	public ProductDTO productRetrieve(Map<String, String> map) {
		ProductDTO dto = template.selectOne("ProductMapper.productRetrieve", map);
		return dto;
	}

}
