package com.myproject.estore.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class sOrderListDTO {
	private int count;
	private List<OrderDTO> list;
	private String pageHtml;
	
	@Builder
	public sOrderListDTO(int count, List<OrderDTO> list, String pageHtml) {
		this.count=count;
		this.list=list;
		this.pageHtml=pageHtml;
	}
}