package com.myproject.estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.ContactDTO;
import com.myproject.estore.mapper.ContactMapper;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactMapper cMapper;
	
	@Override
	public void cInsert(ContactDTO contact) {
		cMapper.cInsert(contact);
	}

	@Override
	public List<ContactDTO> cList() {
		return cMapper.cList();
	}

	@Override
	public int cCount() {
		return cMapper.cCount();
	}

	@Override
	public ContactDTO cfindByNum(int cnum) {
		return cMapper.cfindByNum(cnum);
	}

	@Override
	public void cUpdate(ContactDTO notice) {
		cMapper.cUpdate(notice);
	}

	@Override
	public void cDelete(int cnum) {
		cMapper.cDelete(cnum);
	}

}
