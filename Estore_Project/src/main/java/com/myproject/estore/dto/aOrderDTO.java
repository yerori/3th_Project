package com.myproject.estore.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class aOrderDTO {
	
	private int count;
	private String pageHtml;
	
	private List<OrderDTO> olist;

	@Builder
	public aOrderDTO(int count, List<OrderDTO> olist, String pageHtml) {
		this.count=count;
		this.olist=olist;
		this.pageHtml=pageHtml;
	}
}