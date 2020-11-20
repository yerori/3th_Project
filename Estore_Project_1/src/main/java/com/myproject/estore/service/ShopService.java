package com.myproject.estore.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.dto.Role;
import com.myproject.estore.dto.Shop;
import com.myproject.estore.mapper.ShopMapper;
import com.myproject.estore.repository.AuthRepository;
import com.myproject.estore.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {
	private final ShopRepository sRepository;
	private final AuthRepository aRepository;
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Autowired
	private ShopMapper sMapper;
	
	public Integer sRList(String sid){
		return sMapper.sRList(sid);
	}
	
	//shop product list
		public List<ProductDTO> shopPList(String sid) {
			return sMapper.sPList(sid);
		}

	public List<OrderDTO> shopOList(String sid){
		return sMapper.sOList(sid);
	}
	
	//order상세보기 - 고객정보
	public OrderDTO sOdetailInfo(String sid, String ordernum) {
		return sMapper.sOdetailInfo(sid, ordernum);
	}
	
	//order상세보기 - 제품 리스트
	public List<OrderDTO> sOdetailList(String sid, String ordernum){
		return sMapper.sOdetailList(sid, ordernum);
	}
	
	//order상세보기 수정
	public int sOupdate(OrderDTO order) {
		return sMapper.oUpdate(order);
		
	}
	
	//shop 오늘의 주문 수
	public int newOrderCount(String sid) {
		return sMapper.newOcount(sid);
	}
		   
	
	//shop 정보수정
	@Transactional
	public void update(Shop shop, AuthEntity auth) {
		Shop s2 = sRepository.findByEmail(shop.getEmail())
				.orElseThrow(()->{
					return new IllegalArgumentException("수정 실패: 아이디 없음");
				});
		
		AuthEntity a2 = aRepository.findByEmail(shop.getEmail())
				.orElseThrow(()->{
					return new IllegalArgumentException("수정 실패: 아이디 없음");
				});
		
		
		String rawPass = shop.getPassword();
		String enPass = pwEncoder.encode(rawPass);
		System.out.println(enPass);
		
		s2.setName(shop.getName());
		s2.setAddr(shop.getAddr());
		s2.setName(shop.getSname());
		s2.setPassword(enPass);
		s2.setPhone(shop.getPhone());
		s2.setZipcode(shop.getZipcode());		
		
		AuthEntity.builder()
		.password(auth.getPassword())
		.email(auth.getEmail())
		.build();
		
	}
	
	public Shop EmailCheck(String email){
		Shop shop = sRepository.findByShopemail(email);
		return shop;
	}
	
	@Transactional
	public void save (Shop shop, Auth auth) {		
		//암호화 전
		String rawpassword = shop.getPassword();		
		//암호화 후
		String encodepassword = pwEncoder.encode(rawpassword);
		
		shop.setPassword(encodepassword);
		System.out.println("encodepassword : "+shop.getPassword());
		
		//set은 AuthDTO인 Auth테이블에 해놓기
		auth.setRole(Role.MANAGER);
		AuthEntity authEntity = auth.toEntity();
		
		aRepository.save(authEntity);
		sRepository.save(shop);
	}
	
	//삭제
	public void sDelete(String email) {
		sMapper.sDelete(email);
	}

}
