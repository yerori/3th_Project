package com.myproject.estore.service;

import java.util.HashMap;
import java.util.List
;
import java.util.Optional;

import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.QnADTO;
import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.dto.Role;
import com.myproject.estore.dto.User;
import com.myproject.estore.mapper.UserMapper;
import com.myproject.estore.repository.AuthRepository;
import com.myproject.estore.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository uRepository;
	private final AuthRepository aRepository;
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Autowired
	private UserMapper uMapper;
	
	//회원 추가
	@Transactional
	public void save(User user, Auth auth) {
		user.setRole(Role.USER);
		//암호화 전
		String rawpassword = user.getPassword();		
		//암호화 후
		String encodepassword = pwEncoder.encode(rawpassword);
		
		user.setPassword(encodepassword);
		//System.out.println("encodepassword : "+user.getPassword());
		
		//set은 AuthDTO인 Auth테이블에 해놓기
		auth.setRole(Role.USER);
		AuthEntity authEntity = auth.toEntity();
		
		aRepository.save(authEntity);
		uRepository.save(user);
	}
	   
	public List<User> findAllDesc(){
		return uRepository.findAll();
	}
	
	//이메일 체크 
	public User EmailCheck(String email) {
		User user = uRepository.findByUseremail(email);
		return user;      
	}
	//유저 전체 주문 리스트
	public List<OrderDTO> uOrderList(String uid){
		return uMapper.uOList(uid);
	}
	
	//유저 1달 주문 리스트
	public List<OrderDTO> uMonthList(String uid){
		return uMapper.uMonthList(uid);
	}
	
	//order상세보기 - 고객정보
	public OrderDTO uOdetailInfo(String uid, String ordernum) {
		return uMapper.uOdetailInfo(uid, ordernum);
	}
	
	//order상세보기 - 제품 리스트
	public List<OrderDTO> uOdetailList(String uid, String ordernum){
		return uMapper.uOdetailList(uid, ordernum);
	}
	
	//qna작성 보기
	public List<QnADTO> uQlist(String email){
		return uMapper.uQList(email);
	}
	
	//review리스트
	public List<ReviewDTO> uRlist(String email){
		return uMapper.uRlist(email);
	}
	
	//정보수정
	@Transactional
	public void update(User user, AuthEntity auth) {
		User u2 = uRepository.findByEmail(user.getEmail())
				.orElseThrow(()->{
					return new IllegalArgumentException("수정 실패: 아이디 없음");
				});
				
		AuthEntity a2 = aRepository.findByEmail(user.getEmail())
				.orElseThrow(()->{
					return new IllegalArgumentException("수정 실패: 아이디 없음");
				});
				
		String rawPass = user.getPassword();
		String enPass = pwEncoder.encode(rawPass);
		System.out.println(enPass);
		
		
		u2.setAddr(user.getAddr());
		u2.setName(user.getName());
		u2.setPassword(enPass);
		u2.setPhone(user.getPhone());
		u2.setZipcode(user.getZipcode());	
		
		AuthEntity.builder()
		.password(auth.getPassword())
		.email(auth.getEmail())
		.build();
					
	}
	
	
}
