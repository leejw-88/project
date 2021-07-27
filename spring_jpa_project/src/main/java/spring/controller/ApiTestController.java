package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import spring.service.api.BookSearchApiService;
import spring.service.api.MovieApiService;

@RestController//@Controllert + @ResponseBody
public class ApiTestController {
	
	@Autowired
	MovieApiService movieService;
	@GetMapping("/movie/daily")
	public ModelAndView dailyMovieList(ModelAndView mv) {
		mv.addObject("list" ,movieService.getDailyMovieList());
		mv.setViewName("/board/apitest");
		return mv;
	}
	
	
	@Autowired
	BookSearchApiService bookService;
	@GetMapping("/board/naverBookSearch")
	public ModelAndView bookSearchList(String search, ModelAndView mv) {
		mv.addObject("list" ,bookService.getBookSearchList(search));
		mv.setViewName("/board/apitest2");
		return mv;
	}
}
