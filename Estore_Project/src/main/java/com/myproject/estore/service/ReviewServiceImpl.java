package com.myproject.estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewMapper rMapper;
	
	@Override
	public void rInsert(ReviewDTO review) {
		rMapper.rInsert(review);
	}

	@Override
	public void rUpdate(ReviewDTO review) {
		rMapper.rUpdate(review);
	}

	@Override
	public List<ReviewDTO> rList() {
		return rMapper.rList();
	}

	@Override
	public ReviewDTO rDetail(int rnum) {
		return rMapper.rDetail(rnum);
	}

	@Override
	public void rDelete(int rnum) {
		rMapper.rDelete(rnum);
	}

	@Override
	public List<ReviewDTO> rfindByPnum(int pnum) {
		return rMapper.rfindByPnum(pnum);
	}

	@Override
	public ReviewDTO rfindByOnum(int onum) {		
		return rMapper.rfindByOnum(onum);
	}

	@Override
	public int rCount(int rnum) {
		return rMapper.rCount(rnum);
	}

	@Override
	public int sysCount() {		
		return rMapper.sysCount();
	}

}
