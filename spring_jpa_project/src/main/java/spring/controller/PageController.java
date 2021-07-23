package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	/* 로그인 페이지 이동 */
	@GetMapping("/log/login")
	public String login() {
		return "/log/login";
	}
	/* 회원가입 페이지 이동 */
	@GetMapping("/log/signup")
	public String signup() {
		return "/log/signup";
	}
	// api 테스트페이지 이동
	@GetMapping("/board/apitest")
	public String apitest() {
		return "/board/material/apitest";
	}
}
