package com.myproject.estore.service;

import java.util.List;

import com.myproject.estore.dto.Comment_qnaDTO;

public interface Comment_qnaService {
	//추가
	public void cInsert(Comment_qnaDTO comment);
	//수정
	public void cUpdate(Comment_qnaDTO comment);
	//리스트
	public List<Comment_qnaDTO> cList(int qnum);
	//삭제
	public void cDelete(int cqnum, int qnum);
}
