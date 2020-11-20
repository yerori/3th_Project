package com.myproject.estore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.NoticeDTO;


@Mapper
@Repository
public interface NoticeMapper {
	
	@Insert("insert into notice(title,content,nimg, hitcount) "
			+ "values(#{title}, #{content}, #{nimg}, 0)")
	
	//추가하기
	public void nInsert(NoticeDTO notice);
	//리스트
	public List<NoticeDTO> nList();
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
