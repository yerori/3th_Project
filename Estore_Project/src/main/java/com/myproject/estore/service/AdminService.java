package com.myproject.estore.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.QnADTO;
import com.myproject.estore.dto.ReviewDTO;
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
	
	//리뷰
	public List<ReviewDTO> rList(){
		return aMapper.rList();
	}
	
	//order상세보기 - 고객정보
	public OrderDTO uOdetailInfo(String ordernum) {
		return aMapper.uOdetailInfo(ordernum);
	}
	
	//order상세보기 - 제품 리스트
	public List<OrderDTO> uOdetailList(String ordernum){
		return aMapper.uOdetailList(ordernum);
	}
	
	//유저
	public List<User> uList(HashMap<String, Object> hm){
		return aMapper.uList(hm);
	}
	public int uCount(HashMap<String, Object> hm) {
		return aMapper.uCount(hm);
	}
	
	//상품
	public List<ProductDTO> aPlist(HashMap<String, Object> hm) {
		return aMapper.aPlist(hm);
	}

	//제품 수
	public int aPcount(HashMap<String, Object> hm) {
		return aMapper.aPcount(hm);
	}
		

}
