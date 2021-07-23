package spring.service;

import org.springframework.ui.Model;

import spring.domain.dto.NoticeDto;

public interface NoticeService {

	void getNoticeList(int pageNo, Model model);// 공지사항 리스트출력
	
	void noticeDelete(long no);// 공지사항 글삭제

	void noticeWrite(NoticeDto dto);// 공지사항 글쓰기 저장

	void details(long no, Model model);

}
