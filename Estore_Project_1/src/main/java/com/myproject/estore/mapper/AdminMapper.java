package com.myproject.estore.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.OrderDTO;
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
	
}
