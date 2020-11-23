package com.myproject.estore.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.QnADTO;
import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.dto.Shop;

@Repository
@Mapper
public interface AdminMapper {

	//가게리스트
	public List<Shop> sList(HashMap<String, Object> hm);	
	public int sCount(HashMap<String, Object> hm);
	
	//주문리스트
	public List<OrderDTO> oList(HashMap<String, Object> hm);	
	public int oCount(HashMap<String, Object> hm);
	
	//리뷰 리스트
	public List<ReviewDTO> rList();	

	//주문 상세 조회 - 주문자 정보
	@Select("select ordernum, userid, name, address, phone, pay, create_date, sum(price) total "
			+ "from ordering where ordernum=#{ordernum}")
	public OrderDTO uOdetailInfo(String ordernum);
	
	//주문 상세 조회 - 주문 내역
	@Select("select * from ordering where ordernum=#{ordernum} " )
	public List<OrderDTO> uOdetailList(String ordernum);
	
	//유저리스트
	public List<User> uList(HashMap<String, Object> hm);	
	public int uCount(HashMap<String, Object> hm);
	
	//제품리스트
	public List<ProductDTO> aPlist(HashMap<String, Object> hm);
	
	//가게 상품 개수
	public int aPcount(HashMap<String, Object> hm);
		
}
