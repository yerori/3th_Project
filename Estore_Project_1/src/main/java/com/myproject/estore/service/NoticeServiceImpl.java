package com.myproject.estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.NoticeDTO;
import com.myproject.estore.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper nMapper;
	
	//추가하기
	public void noticeInsert(NoticeDTO notice) {
		nMapper.nInsert(notice);
	}
	
	//list
	@Override
	public List<NoticeDTO> noticeList() {		
		return nMapper.nList();
	}
	
	//개수
	@Override
	public int nCount() {		
		return nMapper.nCount();
	}
	
	//상세보기
	@Override
	public NoticeDTO nfindByNum(int nnum) {
		return nMapper.nfindByNum(nnum);
	}
	
	//수정
	@Override
	public void nUpdate(NoticeDTO notice) {
		nMapper.nUpdate(notice);
		
	}
	@Override
	public void nDelete(int nnum) {
		nMapper.nDelete(nnum);	
	}

	@Override
	public Integer plusCnt(int nnum) {		
		return nMapper.plusCnt(nnum);
	}
	
	
	
}
