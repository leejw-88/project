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
import org.springframework.web.multipart.MultipartFile;

import spring.domain.dto.NoticeDto;
import spring.domain.dto.QnaDto;
import spring.domain.dto.RequestedBookDto;
import spring.domain.dto.ReviewDto;
import spring.service.NoticeService;
import spring.service.QnaService;
import spring.service.RequestedBookService;
import spring.service.ReviewService;

@Controller
public class BoardController {
	@Autowired
	private RequestedBookService requestedBookService;
	@Autowired
	private QnaService qnaService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private ReviewService reviewService;

	
	
	
	
	/* //////////// 도서관안내 페이지 ///////////////////////// */
	@GetMapping("/board/information")//페이지이동
	public String information() {
		return "/board/information/information";
	}

	@GetMapping("/board/information/greetings")//인사말 페이지 불러오기
	public String infoGreetings() {
		return "/board/information/greetings";
	}
	@GetMapping("/board/information/useinfo")//이용안내 페이지 불러오기
	public String infoUseinfo() {
		return "/board/information/useinfo";
	}
	
	/* //////////// 도서자료 페이지 ///////////////////////// */
	@GetMapping("/board/material")//페이지 이동
	public String material() {
		return "/board/material/material";
	}

	@GetMapping("/board/material/detailSearch")//도서검색 페이지 불러오기
	public String matdetailSearch() {
		return "/board/material/detailSearch";
	}
	@GetMapping("/board/material/recommend")//추천도서 페이지 불러오기
	public String matRecommend() {
		return "/board/material/recommend";
	}
	
	/* //////////// 열린마당 페이지 ///////////////////////// */
	@GetMapping("/board/open")//페이지 이동
	public String open() {
		return "/board/open/open";
	}
	/* /////////// 공지사항 페이지 /////////////////////// */
	@GetMapping("/board/open/notice/{pageNo}")//공지사항 리스트 불러오기
	public String openNoticeList(@PathVariable int pageNo,Model model) {
		noticeService.getNoticeList(pageNo, model);
		return "/board/open/notice";
	}
	@ResponseBody
	@DeleteMapping("/board/notice/{no}")//공지사항 페이지 삭제처리
	public void noticeDelete(@PathVariable long no) {
		//System.out.println("delete-no:"+no);
		noticeService.noticeDelete(no);
	}
	@GetMapping("/admin/noticeWrite")// 공지사항 글쓰기 페이지 이동
	public String noticeWrite() {
		return "/admin/noticeWrite";
	}
	@GetMapping("/board/noticeDetails/{no}")// 공지사항 디테일 페이지 이동
	public String noticeDetails(@PathVariable long no,Model model) {
		noticeService.details(no,model);
		return "/board/open/noticeDetails";
	}
	@PostMapping("/board/notice/write")// 공지사항 글쓰기저장
	public String noticeWrite(NoticeDto dto) {
		noticeService.noticeWrite(dto);
		return "redirect:/board/open/notice/1";
	}
	
	
	/* /////////// 묻고답하기(Qna) 페이지 /////////////////////// */
	@GetMapping("/board/open/qnaboard/{pageNo}")//묻고답하기(Qna) 페이지 불러오기
	public String openQnaList(@PathVariable int pageNo,Model model) {
		qnaService.getQnaList(pageNo, model);
		return "/board/open/qnaboard";
	}
	@ResponseBody
	@DeleteMapping("/board/qna/{no}")//묻고답하기(Qna) 페이지 삭제처리
	public void qnaDelete(@PathVariable long no) {
		//System.out.println("delete-no:"+no);
		qnaService.qnaDelete(no);
	}
	@GetMapping("/user/qnaWrite")// Qna 글쓰기 페이지 이동
	public String qnaWrite() {
		return "/user/qnaWrite";
	}
	@GetMapping("/board/qnaDetails/{no}")// Qna 디테일 페이지 이동
	public String qnaDetails(@PathVariable long no,Model model) {
		qnaService.details(no,model);
		return "/board/open/qnaDetails";
	}

	
	@PostMapping("/board/qnaboard/write")// Qna 글쓰기 저장
	public String qnaWrite(QnaDto dto) {
		qnaService.qnaWrite(dto);
		return "redirect:/board/open/qnaboard/1";
	}
	
	/* /////////// 도서감상문 페이지 /////////////////////////// */
	@GetMapping("/board/open/bookReview/{pageNo}")//도서감상문 페이지 불러오기
	public String openBookReviewList(@PathVariable int pageNo,Model model) {
		reviewService.getBookReviewList(pageNo, model);
		return "/board/open/bookReview";
	}
	@GetMapping("/board/reviewDetails/{no}")// 도서감상문 디테일 페이지 이동
	public String reviewDetails(@PathVariable long no,Model model) {
		//요청된 게시글 번호 이용해서 DB에서 상세정보를 받아온다.
		reviewService.details(no,model);
		return "/board/open/bookReviewDetails";
	}
	/*
	@GetMapping("/board/reviewDetails/{no}")// 도서감상문 디테일 페이지 이동2
	public ModelAndView reviewDetails(@PathVariable long no) {
		//요청된 게시글 번호 이용해서 DB에서 상세정보를 받아온다.
		ModelAndView mv=new ModelAndView("/board/open/bookReviewDetails");
		Review detail=reviewService.details(no);
		mv.addObject("dto",detail);
		return mv;
	}
	*/
	@GetMapping("/user/bookReviewWrite")// 도서감상문 글쓰기 페이지 이동
	public String bookReviewWrite() {
		return "/user/bookReviewWrite";
	}
	@PostMapping("/board/bookReview/write")// 도서감상문 글쓰기 저장
	public String bookReviewWrite(MultipartFile file,ReviewDto dto) {
		reviewService.bookReviewWrite(file,dto);
		return "redirect:/board/open/bookReview/1";
	}
	/* 이미지 파일 임시등록 */
	@ResponseBody
	@PostMapping("/board/bookReview/temp")
	public String temp(MultipartFile file) {
		 //System.out.println(file.getOriginalFilename());
		return reviewService.uploadTempFile(file);
	}
	//도서감상문 디테일페이지 수정처리
	@ResponseBody
	@PutMapping("/board/reviewDetails/update/{no}")
	public void detailUpdate(@PathVariable long no,ReviewDto dto) {
		reviewService.detailUpdate(no,dto);
		}
	@ResponseBody
	@DeleteMapping("/board/bookReview/{no}")//도서감상문 페이지 삭제처리
	public void bookreviewDelete(@PathVariable long no) {
		//System.out.println("delete-no:"+no);
		reviewService.bookReviewDelete(no);
	}
	
	/* /////////// 희망도서 페이지 /////////////////////////// */
	@GetMapping("/board/open/requestedbook/{pageNo}")//희망도서 페이지 불러오기
	public String openRequestedBookList(@PathVariable int pageNo,Model model) {
		requestedBookService.getRequestedBookList(pageNo, model);
		return "/board/open/requestedbook";
	}
	@ResponseBody
	@DeleteMapping("/board/requestedbook/{no}")//희망도서 페이지 삭제처리
	public void requestedBookDelete(@PathVariable long no) {
		//System.out.println("delete-no:"+no);
		requestedBookService.requestedBookDelete(no);
	}
	@GetMapping("/user/requestedbookWrite")// 희망도서 글쓰기 페이지 이동
	public String requestedbookWrite() {
		return "/user/requestedbookWrite";
	}
	@PostMapping("/board/requestedbook/write")// 희망도서 글쓰기 저장
	public String requestedbookWrite(RequestedBookDto dto) {
		requestedBookService.requestedbookWrite(dto);
		return "redirect:/board/open/requestedbook/1";
	}
	
	
	
	
	/* //////////// 나의도서관 페이지 ///////////////////////// */
	@GetMapping("/board/mymenu")//페이지 이동
	public String mymenu() {
		return "/board/mymenu/mymenu";
	}
	/* ////////////나의 희망도서 페이지 ///////////////////////// */
	@GetMapping("/board/mymenu/myrequestedbook")//나의 희망도서 페이지 불러오기
	public String myRequestedBook() {
		return "/board/mymenu/myrequestedbook";
	}
	/* ////////////나의 도서감상문 페이지 ///////////////////////// */
	@GetMapping("/board/mymenu/mybookreview")//나의 도서감상문 페이지 불러오기
	public String myBookReview() {
		return "/board/mymenu/mybookreview";
	}


}	