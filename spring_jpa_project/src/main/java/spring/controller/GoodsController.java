package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.dto.GoodsInsertDto;
import spring.service.GoodsService;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService service;
	
	@GetMapping("/admin/goods")
	public String goods() {
		return "/admin/goods/list";
	}
	
	@GetMapping("/admin/goods/write")
	public String write() {
		return "/admin/goods/write";
	}
	
	@PostMapping("/admin/goods")
	public String goods(GoodsInsertDto dto) {
		service.saveAndUpload(dto);
		return "redirect:/admin/goods";
	}
	
	@ResponseBody
	@GetMapping("/admin/goods/all")
	public ModelAndView getList(ModelAndView mv) {
		service.getlist(mv);
		//mv.addObject("list",service.getlist());
		mv.setViewName("/admin/goods/listdata");
		return mv;
	}
}
