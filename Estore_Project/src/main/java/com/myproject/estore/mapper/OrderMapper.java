package com.myproject.estore.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.OrderDTO;

@Repository
@Mapper
public interface OrderMapper {
	 @Insert("insert into onum values()")
	   public int putNum();
	   
	   @Select("select max(onum) from onum")
	   public int getNum();

	   @Insert("insert into ordering"
	         + "(ordernum, sid, pname, pcount, price, userid, name, address, phone, pay, sname, pnum)"
	         + "values(#{ordernum}, #{sid}, #{pname}, #{pcount},#{price},"
	         + "#{userid}, #{name}, #{address}, #{phone}, '카드', #{sname}, #{pnum})")
	   public int oSuccess(OrderDTO order);
	   
	   @Update("update ordering set review='O' where onum=#{onum}")
	   public void update(int onum);
	   
	   //오늘 총 주문 수
	   @Select("select count(*) from ordering where DATE_FORMAT(create_date, '%Y-%m-%d') = CURDATE()")
	   public int sysCount();
	   
	   //오늘 가격
	   @Select("select ifnull(sum(price), 0) from ordering where DATE_FORMAT(create_date, \"%Y-%m-%d\") = CURDATE()")
	   public int price();
	   
	   //이번주 주문수
	   @Select("SELECT count(*) FROM ordering WHERE create_date BETWEEN DATE_ADD(NOW(),INTERVAL -1 WEEK ) AND NOW()")
	   public int weekCount();
	   
	   //이번주 가격
	   @Select("SELECT ifnull(sum(price), 0) FROM ordering WHERE create_date BETWEEN DATE_ADD(NOW(),INTERVAL -1 WEEK ) AND NOW()")
	   public int weekPrice();
}
