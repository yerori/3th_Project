package com.myproject.estore.controller;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.estore.dto.QnADTO;
import com.myproject.estore.service.OrderService;
import com.myproject.estore.service.ProductService;
import com.myproject.estore.service.QnAService;
import com.myproject.estore.service.UserService;

import net.minidev.json.JSONObject;

@Controller
@RequestMapping("/qna/")
public class QnAController {
	@Autowired 
	private QnAService qService;	
	
	@Autowired 
	private ProductService pService;
	
	//list
	@GetMapping("list")
	public String list(Model model) {
		List<QnADTO> qlist = qService.qList();
		model.addAttribute("qlist", qlist);
		return "/qna/qList";
	}
	
	//추가폼
	@GetMapping("insert/{pnum}")
	public String insert(@PathVariable("pnum") int pnum, Model model) {
		model.addAttribute("pnum", pnum);
		return "/qna/qInsert";
	}
	
	//추가
	@PostMapping("insert")
	@ResponseBody //@ResponseBody + @RequestBody = @RestController
	public String insert(@RequestBody QnADTO qna, Principal principal) {
		qna.setEmail(principal.getName());
		qService.qInsert(qna);
		return "success";
	}
	
	//product상세 페이지 내 리스트
	@GetMapping("plist")
	@ResponseBody //return형이 json
	public List<QnADTO> list(int pnum) {
		List<QnADTO> qna = qService.qfindByPnum(pnum);		
		return qna;
	}
		
	//상세보기
	@GetMapping("detail/{qnum}")
	public String detail(@PathVariable("qnum") int qnum, Model model) {
		QnADTO qdto = qService.qDetail(qnum);		
		model.addAttribute("qna", qdto);
		return "/qna/qDetail";
	}
	
	//상세보기
	@GetMapping("udetail/{qnum}")
	public String udetail(@PathVariable("qnum") int qnum, Model model) {
		QnADTO qdto = qService.qDetail(qnum);		
		model.addAttribute("qna", qdto);
		return "/qna/quDetail";
	}
	
	//비밀번호 확인 폼
	@GetMapping("pwform/{qnum}")
	public String pwform(@PathVariable("qnum") int qnum, Model model) {
		model.addAttribute("qnum", qnum);
		return "/qna/qPwCheck";
	}
	
	@PostMapping("pwcheck")
	@ResponseBody
	public String pwcheck(@Param("qnum") int qnum, @Param("password") String password) {
		QnADTO qdto = qService.qDetail(qnum);
		String flag = "";
		if(qdto.getPassword().equals(password)) {
			flag="yes";
		}
		else if(!qdto.getPassword().equals(password)) {
			flag="no";
		}
		return flag;
	}
	
	//수정하기 폼으로
	@GetMapping("update/{qnum}")
	public String update(@PathVariable int qnum, Model model) {
		QnADTO qdto = qService.qDetail(qnum);
		model.addAttribute("qna", qdto);
		return "/qna/qUpdate";
	}
	
	//수정하기
	@PostMapping("update")
	public String update(QnADTO qna) {
		qService.qUpdate(qna);
		return "redirect:/user/uQnA";
	}
	//삭제
	@GetMapping("delete")
	@ResponseBody
	public String delete(int qnum) {
		qService.qDelete(qnum);
		return "success";
	}
}
