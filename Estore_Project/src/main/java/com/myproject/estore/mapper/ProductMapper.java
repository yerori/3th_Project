package com.myproject.estore.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.ProductDTO;

@Repository
@Mapper
public interface ProductMapper {
	//추가하기
	@Insert("insert into product(sid, ptype, pname, price, pimg, pdetail, sname) "
			+ "values(#{sid}, #{ptype}, #{pname}, #{price}, #{pimg}, #{pdetail}, #{sname})")
	public int pInsert(ProductDTO product);
	
	//리스트
	public List<ProductDTO> pList(String word);
	
	//검색
	public List<ProductDTO> searchList(String word);
	
	//상세보기
	@Select("select * from product where pnum=#{pnum}")
	public ProductDTO pDetail(Long pnum);
	
	//수정하기
	@Update("update product set ptype=#{ptype}, pname=#{pname}, price=#{price},"
			+ "pimg=#{pimg}, pdetail=#{pdetail} where pnum=#{pnum}")
	public int pUpate(ProductDTO product);
	
	//삭제하기
	public void pDelete(Long pnum);
}
