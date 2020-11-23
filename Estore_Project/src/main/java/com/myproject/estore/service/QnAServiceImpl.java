package com.myproject.estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.QnADTO;
import com.myproject.estore.mapper.QnAMapper;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnAMapper qMapper;
	
	@Override
	public void qInsert(QnADTO qna) {
		qMapper.qInsert(qna);
	}

	@Override
	public void qUpdate(QnADTO qna) {
		qMapper.qUpdate(qna);
	}

	@Override
	public List<QnADTO> qList() {
		return qMapper.qList();
	}

	@Override
	public QnADTO qDetail(int qnum) {
		return qMapper.qDetail(qnum);
	}

	@Override
	public void qDelete(int qnum) {
		qMapper.qDelete(qnum);
	}

	@Override
	public List<QnADTO> qfindByPnum(int pnum) {		
		return qMapper.qfindByPnum(pnum);
	}

	@Override
	public int qnaCount() {		
		return qMapper.qnaCount();
	}

	@Override
	public int noReply() {
		return qMapper.noReply();
	}


}
