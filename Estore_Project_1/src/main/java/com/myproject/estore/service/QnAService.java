package com.myproject.estore.service;

import java.util.List;

import com.myproject.estore.dto.QnADTO;

public interface QnAService {
	//추가
	public void qInsert(QnADTO qna);
	//수정
	public void qUpdate(QnADTO qna);
	//리스트
	public List<QnADTO> qList();
	//상세보기
	public QnADTO qDetail(int qnum);
	//삭제
	public void qDelete(int qnum);
	//product에 따른 상세보기
	public List<QnADTO> qfindByPnum(int pnum);
	//오늘 개수
	public int qnaCount();
}
