package com.myproject.estore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.estore.dto.Comment_qnaDTO;
import com.myproject.estore.service.Comment_qnaService;
import com.myproject.estore.service.QnAService;

@RestController
@RequestMapping("/comment/")
public class Comment_qnaController {
	@Autowired
	private Comment_qnaService cService;
	
	@Autowired
	private QnAService qService;
	
	//QnA 폼 내 리스트
	@GetMapping("list")
	public List<Comment_qnaDTO> list(int qnum){
		List<Comment_qnaDTO> clist = cService.cList(qnum);
		return clist;
	}
	
	//추가
	//principal 쓰기 
	@PostMapping("insert")
	public String insert(@RequestBody Comment_qnaDTO comment, Principal principal ) {
		comment.setSemail(principal.getName());
		cService.cInsert(comment);
		return "success";		
	}
	
	//삭제
	@GetMapping("delete")
	public String delete(int cqnum, int qnum) {
		cService.cDelete(cqnum, qnum);
		return "success";
	}

}
