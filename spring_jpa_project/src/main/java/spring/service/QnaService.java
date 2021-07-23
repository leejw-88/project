package spring.service;

import org.springframework.ui.Model;

import spring.domain.dto.QnaDto;
import spring.domain.dto.QnaUpdateDto;

public interface QnaService {

	void getQnaList(int pageNo, Model model);// qna 리스트출력
	
	void qnaWrite(QnaDto dto);// qna 글쓰기
	
	void qnaDelete(long no);// qna 글삭제
	
	void qnaUpdate(long no, QnaUpdateDto dto);// qna글수정

	void details(long no, Model model);// qna 디테일페이지


	

}
