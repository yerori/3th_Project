package com.myproject.estore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.ContactDTO;

@Mapper
@Repository
public interface ContactMapper {
	@Insert("insert into contact(content,name,email, title) "
			+ "values(#{content}, #{name}, #{email}, #{title})")	
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
