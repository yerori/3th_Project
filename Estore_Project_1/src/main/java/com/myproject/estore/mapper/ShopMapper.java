package com.myproject.estore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.CartDTO;
import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.dto.Shop;

@Repository
@Mapper
public interface ShopMapper {
	
	//review와 product조인
	public int sRList(String sid); 
	
	//가게 상품 조회
	@Select("select * from product where sid=#{sid}")
	public List<ProductDTO> sPList(String sid);
	
	//주문 조회
	@Select("select ordernum, name, userid, sum(pcount) sum, price, create_date, orderstate "
			+ "from ordering where sid=#{sid} group by ordernum order by create_date asc")
	public List<OrderDTO> sOList(String sid);
	
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
	
	@Delete("delete from shop where email=#{email}")
	public void sDelete(String email);
	
}
