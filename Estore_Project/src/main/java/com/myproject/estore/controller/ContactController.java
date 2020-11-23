package com.myproject.estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.estore.dto.ContactDTO;
import com.myproject.estore.service.ContactService;

@Controller
@RequestMapping("/contact/")
public class ContactController {
	private static final List<ContactDTO> ContactDTO = null;
	@Autowired
	private ContactService cService;
	
	
	@GetMapping("form")
	public String insertform() {
		return "/contact/cInsert";
	}
	
	@PostMapping("insert")
	public String insert(ContactDTO contact, Model model) {
		cService.cInsert(contact);
		return "/contact/cConfirm";
	}
	
	
	
}
