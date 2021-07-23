package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import spring.service.api.BookSearchApiService;

@RestController//@Controllert + @ResponseBody
public class ApiTestController {
	
	@Autowired
	BookSearchApiService bookService;
	
	//네이버 도서검색
	@GetMapping("/board/naverBookSearch")
	public ModelAndView bookSearchList(String search, ModelAndView mv) {
		mv.addObject("list" ,bookService.getBookSearchList(search));
		mv.setViewName("/board/apitest2");
		return mv;
	}
}
