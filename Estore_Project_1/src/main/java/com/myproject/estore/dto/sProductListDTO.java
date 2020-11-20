package com.myproject.estore.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class sProductListDTO {
	private int count;
	private List<ProductDTO> list;
	private String pageHtml;
	
	@Builder
	public sProductListDTO(int count, List<ProductDTO> list, String pageHtml) {
		this.count=count;
		this.list=list;
		this.pageHtml=pageHtml;
	}
}