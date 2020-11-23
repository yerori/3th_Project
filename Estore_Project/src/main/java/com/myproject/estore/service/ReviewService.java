package com.myproject.estore.service;

import java.util.List;

import com.myproject.estore.dto.ReviewDTO;

public interface ReviewService {
	//추가
	public void rInsert(ReviewDTO review);
	//수정
	public void rUpdate(ReviewDTO review);
	//리스트
	public List<ReviewDTO> rList();
	//상세보기
	public ReviewDTO rDetail(int rnum);
	//삭제
	public void rDelete(int rnum);
	//product에 따른 상세보기
	public List<ReviewDTO> rfindByPnum(int pnum);
	//onum에 따른 list
	public ReviewDTO rfindByOnum(int onum);
	//review 수
	public int rCount(int rnum);
	//오늘 리뷰 수
	public int sysCount();
}
