package com.myproject.estore.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.Shop;
import com.myproject.estore.mapper.AdminMapper;

@Service
public class AdminService {

	@Autowired
	private AdminMapper aMapper;
	
	//가게리스트
	public List<Shop> sList(HashMap<String, Object> hm){
		return aMapper.sList(hm);
	}
	public int sCont(HashMap<String, Object> hm) {
		return aMapper.sCount(hm);
	}
	
	//주문리스트
	public List<OrderDTO> oList(HashMap<String, Object> hm){
		return aMapper.oList(hm);
	}
	public int oCont(HashMap<String, Object> hm) {
		return aMapper.oCount(hm);
	}

}
