package com.myproject.estore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.Comment_qnaDTO;

@Mapper
@Repository
public interface Comment_qnaMapper {
	@Insert("insert into comment_qna(qnum, content, uemail, semail) "
			+ "values(#{qnum}, #{content}, #{uemail}, #{semail}) ")
	//추가
	public void cInsert(Comment_qnaDTO comment);
	//수정
	public void cUpdate(Comment_qnaDTO comment);
	//리스트
	public List<Comment_qnaDTO> cList(int qnum);
	//삭제
	public void cDelete(int cqnum);
}
