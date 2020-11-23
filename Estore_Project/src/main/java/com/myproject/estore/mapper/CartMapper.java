package com.myproject.estore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.myproject.estore.dto.CartDTO;

@Repository
@Mapper
public interface CartMapper {
 //추가하기
   public int cInsert(CartDTO cart);
   
   //리스트
   public List<CartDTO> cList(String userid);
   
   //갯수
   public int cCount(String userid);
   
   //선택삭제
   public void cDelete(Long cnum);

   //전체삭제
   public void allDelete(String userid);


}
