package spring.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.domain.dto.QnaDto;
import spring.domain.dto.QnaUpdateDto;
import spring.domain.entity.QnaEntity;
import spring.domain.repository.QnaRepository;

@Service
public class QnaServiceImpl implements QnaService{
	
	@Autowired
	private QnaRepository qnaRepository;

	/*
	 * // qna 글쓰기 저장
	 * 
	 * @Override public void qnaWrite(QnaDto dto) {
	 * qnaRepository.save(dto.toEntity()); }
	 */
	// qna 글쓰기 저장
	@Override
	public void qnaWrite(QnaDto dto) {
		qnaRepository.save(dto.toEntity());		
	}
	// qna 리스트 출력
	@Override
	public void getQnaList(int pageNo, Model model) {
		Sort sort=Sort.by(Direction.DESC,"updatedDate");
		Pageable pageable=PageRequest.of(pageNo-1,5, sort);
		Page<QnaEntity> result = qnaRepository.findAll(pageable);
		int pagetotal=result.getTotalPages();
		//출력하기위해 배열로 바꿈
		List<QnaDto> list=
				result.getContent() //BoardDto에 있는 객체를 List타입으로 
				.stream().map(QnaDto::new)//entity -> new BoardDto(entity)
				.collect(Collectors.toList());
		
		model.addAttribute("qnaList", list);
		model.addAttribute("pagetotal", pagetotal);
	}
	// qna 삭제
	@Override
	public void qnaDelete(long no) {
		qnaRepository.deleteById(no);
	}
	// qna 수정
	@Transactional
	@Override
	public void qnaUpdate(long no, QnaUpdateDto dto) {
		qnaRepository.findById(no)
						.map(entity->entity.update(dto))
						.get();
	}
	//디테일페이지 출력
	@Override
	public void details(long no, Model model) {
		QnaDto result = qnaRepository.findById(no)
				.map(QnaDto::new)
				.orElseThrow();
		model.addAttribute("dto",result);
	}




	


	


}
