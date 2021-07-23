package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.domain.dto.MemberRequestDto;
import spring.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@ResponseBody
	@PostMapping("/member/check")
	public boolean check(String id) {
		//log.debug(id);
		return service.idCheck(id);
	}
	
	@PostMapping("/member/signup")
	public String join(MemberRequestDto dto, Model model) {
		//log.debug("******회원가입처리******");
		service.join(dto, model);
		return "/index";
	}
}
