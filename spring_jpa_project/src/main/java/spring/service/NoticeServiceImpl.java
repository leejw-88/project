package spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.domain.dto.NoticeDto;
import spring.domain.entity.Notice;
import spring.domain.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeRepository noticeRepository;

	// 공지사항 리스트 출력
	@Override
	public void getNoticeList(int pageNo, Model model) {
		Sort sort=Sort.by(Direction.DESC,"updatedDate");
		Pageable pageable=PageRequest.of(pageNo-1,5, sort);
		
		Page<Notice> result = noticeRepository.findAll(pageable);
		int pagetotal=result.getTotalPages();
		//조회결과 List<NoticeDto> 로 저장
		List<NoticeDto> list=
				result.getContent() //NoticeDto에 있는 객체를 List타입으로 
				.stream().map(NoticeDto::new)//entity -> new BoardDto(entity)
				.collect(Collectors.toList());
		//페이지에서 확인할수 있도록 Model에 "noticeList"이름으로 저장
		model.addAttribute("noticeList", list);
		//페이지에서 확인할수 있도록 Model에 "pagetotal"이름으로 저장
		model.addAttribute("pagetotal", pagetotal);
	}
	//디테일페이지 출력
	public void details(long no,Model model) {
		NoticeDto result = noticeRepository.findById(no)
				.map(NoticeDto::new)
				.orElseThrow();
		model.addAttribute("dto",result);
	}

	// 공지사항 글쓰기 저장
	@Override
	public void noticeWrite(NoticeDto dto) {
		noticeRepository.save(dto.toEntity());		
	}
	// 공지사항 글 삭제
	@Override
	public void noticeDelete(long no) {
		noticeRepository.deleteById(no);
	}


}
