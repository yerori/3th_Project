package com.myproject.estore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.User;

@Repository
@Mapper
public interface UserMapper {
	
	
	//주문 상세 조회 - 주문자 정보
	@Select("select ordernum, userid, name, address, phone, pay, create_date, sum(price) total "
			+ "from ordering where ordernum=#{ordernum} and userid=#{sid} group by ordernum")
	public OrderDTO uOdetailInfo(String sid, String ordernum);
	
	//주문 상세 조회 - 주문 내역
	@Select("select onum, pname, pcount, price, orderstate from ordering "
			+ "where ordernum=#{ordernum} and userid=#{sid}")
	public List<OrderDTO> uOdetailList(String sid, String ordernum);

	//나의 전체 주문리스트
	@Select("select sum(pcount) sum, ordernum, create_date, sum(price) total from ordering where userid=#{uid} group by ordernum")
	public List<OrderDTO> uOList(String uid);
	
	//한달간 주문리스트
	@Select("SELECT * FROM ordering WHERE create_date BETWEEN DATE_ADD(NOW(),INTERVAL -1 MONTH ) AND NOW()")
	public List<OrderDTO> uMonthList(String uid);
	

}
