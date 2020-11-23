package com.myproject.estore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.mapper.OrderMapper;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper oMapper;
	
	@Transactional
	public int getNum() {
		oMapper.putNum();
		return oMapper.getNum();
	}
	
	public int orderSuccess(OrderDTO order) {
		return oMapper.oSuccess(order);
	}
	
	public void update(int onum) {
		oMapper.update(onum);
	}
	
	public int sysCount() {
		return oMapper.sysCount();
	}
	
	public int price() {
		return oMapper.price();
	}
	
	public int weekCount() {
		return oMapper.weekCount();
	}
	
	public int weekPrice() {
		return oMapper.weekPrice();
	}

}
