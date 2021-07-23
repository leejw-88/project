package spring.service;

import org.springframework.ui.Model;

import spring.domain.dto.RequestedBookDto;

public interface RequestedBookService {

	void getRequestedBookList(int pageNo, Model model);// 희망도서 리스트 출력
	
	void requestedBookDelete(long no);// 희망도서 글 삭제

	void requestedbookWrite(RequestedBookDto dto);// 희망도서 글쓰기
	
	
}
