package com.myproject.estore.service;


import java.util.List;

import com.myproject.estore.dto.ProductDTO;

public interface ProductService {

	public int productInsert(ProductDTO product);
	
	public List<ProductDTO> productList(String word);
	
	public List<ProductDTO> searchList(String word);
	
	public ProductDTO productDetail(Long pnum);
	
	public int productUpdate(ProductDTO product);
	
	public void productDelete(Long pnum);
}
