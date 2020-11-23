package com.myproject.estore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.Comment_qnaDTO;
import com.myproject.estore.mapper.Comment_qnaMapper;
import com.myproject.estore.mapper.QnAMapper;

@Service
public class Comment_qnaServiceImpl implements Comment_qnaService{
	@Autowired
	private Comment_qnaMapper cMapper;
	
	@Autowired
	private QnAMapper qMapper;
	
	@Override
	@Transactional
	public void cInsert(Comment_qnaDTO comment) {
		qMapper.ReplayCnt(comment.getQnum(), 1);
		cMapper.cInsert(comment);
	}

	@Override
	public void cUpdate(Comment_qnaDTO comment) {
		cMapper.cUpdate(comment);
	}

	@Override
	public List<Comment_qnaDTO> cList(int qnum) {		
		return cMapper.cList(qnum);
	}

	@Override
	public void cDelete(int cqnum,  int qnum) {
		qMapper.ReplayCnt(qnum, -1);
		cMapper.cDelete(cqnum);
	}

}
