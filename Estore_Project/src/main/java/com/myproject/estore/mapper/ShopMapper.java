package com.myproject.estore.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.CartDTO;
import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.QnADTO;
import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.dto.Shop;

@Repository
@Mapper
public interface ShopMapper {
	
	//review와 product조인 - 리뷰수
	public int sRList(String sid); 
	
	//가게 상품 조회
	public List<ProductDTO> sPList(HashMap<String, Object> hm);
	
	//가게 상품 개수
	public int pCount(HashMap<String, Object> hm);
	
	//주문 조회
	public List<OrderDTO> sOList(HashMap<String, Object> hm);

	//주문 수
	public int oCount(HashMap<String, Object> hm);
	
	//주문 상세 조회 - 주문자 정보
	@Select("select ordernum, userid, name, address, phone, pay, create_date, sum(price) total "
			+ "from ordering where ordernum=#{ordernum} and sid=#{sid} group by ordernum")
	public OrderDTO sOdetailInfo(String sid, String ordernum);
	
	//주문 상세 조회 - 주문 내역
	@Select("select onum, pname, pcount, price, orderstate from ordering "
			+ "where ordernum=#{ordernum} and sid=#{sid}")
	public List<OrderDTO> sOdetailList(String sid, String ordernum);
	
	//주문 내역 수정
	@Update("update ordering set orderstate=#{orderstate} where onum=#{onum}")
	public int oUpdate(OrderDTO order);
	
	//오늘 판매 수량
	@Select("select count(*) from ordering where sid=#{sid} "
			+ "and DATE_FORMAT(create_date, '%Y-%m-%d') = CURDATE()")
	public int newOcount(String sid);
	
	//오늘 판매 금액
	@Select("select ifnull(sum(price),0) from ordering where sid=#{sid} "
				+ "and DATE_FORMAT(create_date, '%Y-%m-%d') = CURDATE()")
	public int newOsum(String sid);
	
	//이번주 판매 수량
	@Select("select count(*) from ordering where sid=#{sid} " 
			+ "and create_date BETWEEN DATE_ADD(NOW(),INTERVAL -1 WEEK ) AND NOW()")
	public int weekOcount(String sid);
	
	//이번주 판매 금액
	@Select("SELECT ifnull(sum(price),0) FROM ordering WHERE sid=#{sid} and "
			+ "create_date BETWEEN DATE_ADD(NOW(),INTERVAL -1 WEEK ) AND NOW()")
	public int weekOsum(String sid);

	//qna 전체 리스트
	public List<QnADTO> sQList(String sid);	
	
	//오늘 qna 갯수
	public int todayQlist(String sid);
	
	//댓글 0인 qna
	public int noReply(String sid);
	
	//리뷰리스트
	public List<ReviewDTO> sRlist(String sid);
	
	@Delete("delete from shop where email=#{email}")
	public void sDelete(String email);
	//오늘 리뷰 수
	@Select("select count(*) from review where sid=#{sid} and "
			+ "DATE_FORMAT(create_date, '%Y-%m-%d') = CURDATE()")
	public int todayReview(String sid);
	
	//이번주 리뷰 수 
	@Select("select count(*) from review where sid=#{sid} and "
			+ "create_date BETWEEN DATE_ADD(NOW(),INTERVAL -1 WEEK ) AND NOW()")
	public int weekReview(String sid);
	
}
