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

import spring.domain.dto.RequestedBookDto;
import spring.domain.entity.RequestedBook;
import spring.domain.repository.RequestedBookRepository;

@Service
public class RequestedBookServiceImpl implements RequestedBookService {

	@Autowired
	private RequestedBookRepository requestedBookRepository;

	//희망도서 리스트 출력
	@Override
	public void getRequestedBookList(int pageNo, Model model) {
		Sort sort=Sort.by(Direction.DESC,"updatedDate");
		Pageable pageable=PageRequest.of(pageNo-1,5, sort);
		Page<RequestedBook> result = requestedBookRepository.findAll(pageable);
		int pagetotal=result.getTotalPages();
		//출력하기위해 배열로 바꿈
		List<RequestedBookDto> list=
				result.getContent() //NoticeDto에 있는 객체를 List타입으로 
				.stream().map(RequestedBookDto::new)//entity -> new BoardDto(entity)
				.collect(Collectors.toList());
		
		model.addAttribute("RequestedBookList", list);
		model.addAttribute("pagetotal", pagetotal);
	}

	//희망도서 글쓰기 저장
	@Override
	public void requestedbookWrite(RequestedBookDto dto) {
		requestedBookRepository.save(dto.toEntity());
	}
	//희망도서 글 삭제
	@Override
	public void requestedBookDelete(long no) {
		requestedBookRepository.deleteById(no);	
	}

	



}
