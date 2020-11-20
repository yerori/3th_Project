package com.myproject.estore.service;

import java.util.List;

import com.myproject.estore.dto.ContactDTO;

public interface ContactService {
	//추가하기
		public void cInsert(ContactDTO contact);
		//리스트
		public List<ContactDTO> cList();
		//개수
		public int cCount();
		//상세보기
		public ContactDTO cfindByNum(int cnum);
		//수정
		public void cUpdate(ContactDTO notice);
		//삭제
		public void cDelete(int cnum);
}
