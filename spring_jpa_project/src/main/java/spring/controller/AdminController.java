package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.domain.dto.QnaDto;
import spring.domain.dto.QnaUpdateDto;
import spring.service.QnaService;

@Controller
public class AdminController {
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("/admin/list")// 관리자페이지 이동
	public String adminList() {
		return "/admin/list";
	}
	/* ///////////////////////////////////////////////////////// */
	@GetMapping("/admin/qna/list")// 관리자qna페이지 이동
	public String adminQnaList() {
		return "/admin/qna/list";
	}
	@GetMapping("/admin/qna/listdata/{pageNo}")// 관리자qna리스트 출력
	public String qnaList(@PathVariable int pageNo,Model model) {
		qnaService.getQnaList(pageNo,model);
		return "/admin/qna/listdata";
	}
	//관리자페이지 qna삭제처리
	@ResponseBody
	@DeleteMapping("/admin/qna/list/{no}")
	public void adminDelete(@PathVariable long no) {
		System.out.println("delete-no:"+no);
		qnaService.qnaDelete(no);
	}
	//관리자페이지 qna수정처리
	@ResponseBody
	@PutMapping("/admin/qna/list/{no}")
	public void adminUpdate(@PathVariable long no,QnaUpdateDto dto) {
		System.out.println("edit-no:"+no);
		//System.out.println("edit-no:"+dto.getTitle());
		//System.out.println("edit-no:"+dto.getContent());
		qnaService.qnaUpdate(no,dto);
	}
	
	@GetMapping("/admin/qna/write")// admin Qna 글쓰기페이지 이동
	public String adminQnaWrite() {
		return "/admin/qna/write";
	}
	@PostMapping("/admin/qna/write")// admin Qna 글쓰기 저장
	public String adminQnaWrite(QnaDto dto) {
		qnaService.qnaWrite(dto);
		return "/admin/qna/write";
	}
	
	


	
}
