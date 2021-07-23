package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import spring.domain.dto.BookWriteDto;
import spring.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/admin/book/write")
	public String write() {
		return "/admin/book/write";
	}
	//도서 목록보기 페이지
	@GetMapping("/admin/book")
	public String movie(Model model) {
		bookService.movieList(model);
		return "/admin/book/list";
	}
	
	@PostMapping("/admin/book/write")
	public String write(MultipartFile file, BookWriteDto dto) {
		
		bookService.insert(file, dto);
		
		return "redirect:/admin/book";
	}

	@ResponseBody
	@PostMapping("/admin/book/temp")
	public String temp(MultipartFile file) {
		 //System.out.println(file.getOriginalFilename());
		return bookService.uploadTempFile(file);
	}
	
}
