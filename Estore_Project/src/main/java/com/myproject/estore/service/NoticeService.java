package com.myproject.estore.service;

import java.util.List;

import com.myproject.estore.dto.NoticeDTO;

public interface NoticeService {
	//추가
	public void noticeInsert(NoticeDTO notice);
	//전체보기
	public List<NoticeDTO> noticeList();
	//개수
	public int nCount();
	//상세보기
	public NoticeDTO nfindByNum(int nnum);
	//수정
	public void nUpdate(NoticeDTO notice);
	//삭제
	public void nDelete(int nnum);
	//조회수 증가
	public Integer plusCnt(int nnum);
}
