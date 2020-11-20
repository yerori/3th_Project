package com.myproject.estore.dto;

import org.springframework.stereotype.Component;

@Component
public class PageAction {
   public String paging(int count, int pageSize, int currentPage, String field, String word) {
      String file="javascript:getData(";
      
      int pageCount = count/pageSize+(count%pageSize==0?0:1);
      int pageBlock = 5;//이전과 다음 사이의 페이지 갯수
      int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
      int endPage = startPage+pageBlock-1;
      if(endPage>pageCount) endPage=pageCount;
      
      StringBuilder sb = new StringBuilder();
      if(count>0) {
         //이전
         if(startPage>pageBlock) {
            sb.append("<a href=");
            sb.append(file);
            sb.append((startPage-pageBlock));
            sb.append(",'"+field);
            sb.append("','"+word+"')");
            sb.append(">이전</a>");            
         }
         
         //페이지번호
         for(int i=startPage; i<=endPage; i++) {
            if(i==currentPage) {//현재 페이지 링크 없음
               sb.append("["+i+"]");
            }else {//현재 페이지 아님 링크 걸기
               sb.append("<a href=");
               sb.append(file);
               sb.append(i);
               sb.append(",'"+field);
               sb.append("','"+word+"')");
               sb.append(">["+i+"]</a>");
            }
         }
         
         //다음
         if(endPage<pageCount) {
            sb.append("<a href=");
            sb.append(file);
            sb.append((startPage+pageBlock));
            sb.append(",'"+field);
            sb.append("','"+word+"')");
            sb.append(">다음</a>");   
         }
      }

      return sb.toString();
   }

}