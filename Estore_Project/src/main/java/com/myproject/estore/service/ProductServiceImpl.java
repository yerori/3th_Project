package com.myproject.estore.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.mapper.ProductMapper;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper pMapper;
	
	//상품등록
	public int productInsert(ProductDTO product) {
		return pMapper.pInsert(product);
	}

	//상품리스트
	@Override
	public List<ProductDTO> productList(String word) {
		return pMapper.pList(word);
	}

	//상품상세보기
	@Override
	public ProductDTO productDetail(Long pnum) {
		return pMapper.pDetail(pnum);
	}

	//수정
	@Override
	public int productUpdate(ProductDTO product) {
		return pMapper.pUpate(product);
	}

	//삭제
	@Override
	public void productDelete(Long pnum) {
		pMapper.pDelete(pnum);
	}

	//검색리스트
	@Override
	public List<ProductDTO> searchList(String word) {
		return pMapper.searchList(word);
	}
}
