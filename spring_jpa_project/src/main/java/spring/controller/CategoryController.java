package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.dto.CategoryDto;
import spring.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/admin/category")
	public String category() {
		return "/admin/category/write";
	}
	
	@PostMapping("/admin/category")
	public String category(CategoryDto dto) {
		categoryService.save(dto);
		return "/admin/category/write";
	}
	
	//1차 카테고리 정보를 읽어와서 페이지로 데이터 전송
	@ResponseBody
	@GetMapping("/admin/category/first")
	public ModelAndView first(ModelAndView mv) {
		categoryService.findAllFirst(mv);
		mv.setViewName("/admin/category/data");
		return mv;
	}
	//2차 카테고리 정보를 읽어와서 페이지로 데이터 전송
	@ResponseBody
	@GetMapping("/admin/category/{first}/second")
	public ModelAndView second(@PathVariable int first,ModelAndView mv) {
		categoryService.findAllSecond(first,mv);
		mv.setViewName("/admin/category/data");
		return mv;
	}
	//3차 카테고리 정보를 읽어와서 페이지로 데이터 전송
	@ResponseBody
	@GetMapping("/admin/category/{first}/{second}/third")
	public ModelAndView third(@PathVariable int first,@PathVariable int second,ModelAndView mv) {
		categoryService.findAllThird(first,second,mv);
		mv.setViewName("/admin/category/data");
		return mv;
	}
	//4차 카테고리 정보를 읽어와서 페이지로 데이터 전송
	@ResponseBody
	@GetMapping("/admin/category/{first}/{second}/{third}/detail")
	public ModelAndView detail(@PathVariable int first,@PathVariable int second,@PathVariable int detail,ModelAndView mv) {
		categoryService.findAllDetail(first,second,detail,mv);
		mv.setViewName("/admin/category/data");
		return mv;
	}
}
