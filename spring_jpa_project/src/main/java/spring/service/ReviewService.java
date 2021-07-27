package spring.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import spring.domain.dto.ReviewDto;

public interface ReviewService {

	void getBookReviewList(int pageNo, Model model);// 도서감상문 리스트 출력
	
	void bookReviewDelete(long no);// 도서감상문 글 삭제

	void bookReviewWrite(MultipartFile file, ReviewDto dto);// 도서감상문 글쓰기

	void details(long no, Model model);// 도서감상문 디테일페이지

	String uploadTempFile(MultipartFile file);//임시파일 업로드

	//Review details(long no);// 도서감상문 디테일페이지2

	void detailUpdate(long no, ReviewDto dto);//도서감상문 업데이트

}
