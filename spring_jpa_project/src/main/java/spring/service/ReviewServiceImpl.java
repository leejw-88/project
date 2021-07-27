package spring.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import spring.domain.dto.ReviewDto;
import spring.domain.entity.Review;
import spring.domain.repository.ReviewRepository;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;
	//도서감상문 리스트 출력
	@Override
	public void getBookReviewList(int pageNo, Model model) {
		Sort sort=Sort.by(Direction.DESC,"updatedDate");
		Pageable pageable=PageRequest.of(pageNo-1,5, sort);
		Page<Review> result = reviewRepository.findAll(pageable);
		int pagetotal=result.getTotalPages();
		//출력하기위해 배열로 바꿈
		List<ReviewDto> list=
				result.getContent() //NoticeDto에 있는 객체를 List타입으로 
				.stream().map(ReviewDto::new)//entity -> new BoardDto(entity)
				.collect(Collectors.toList());
		
		model.addAttribute("bookReviewList", list);
		model.addAttribute("pagetotal", pagetotal);
	}
	//도서감상문 글쓰기 저장
	@Override
	public void bookReviewWrite(MultipartFile file,ReviewDto dto) {
		//1.file정보
		long fileSize=file.getSize();
		if(fileSize>2*1024*1024) {
			log.error("파일 용량 초과!");
			return;
		}
		String fileName=file.getOriginalFilename();
		String fileUrl="/images/book/";
		//static/images/book/
		ClassPathResource cpr=new ClassPathResource("static"+fileUrl);
		ClassPathResource tempCpr=new ClassPathResource("static"+fileUrl+"temp/");
		try {
			//File location=cpr.getFile();
			//파일업로드(X): 임시폴더에 이미 존재하고 있으니-->이동시킵시다.
			//file.transferTo(new File(location, fileName));
			File tempFile=new File(tempCpr.getFile(), fileName);
			if(tempFile.exists()) {
				tempFile.renameTo(new File(cpr.getFile(), fileName));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//2. DB에저장
		//	    1.Dto 파일정보 셋팅
		dto.setFileName(fileName);
		dto.setFileUrl(fileUrl);
		dto.setFileSize(fileSize);
		//	    2.entity로 변환 저장
		reviewRepository.save(dto.toEntity());
	}
	//파일 임시저장
		@Override
		public String uploadTempFile(MultipartFile file) {
			//1.file정보
			long fileSize=file.getSize();
			if(fileSize>2*1024*1024) {
				log.error("파일 용량 초과!");
				return null;
			}
			String fileName=file.getOriginalFilename();
			String fileUrl="/images/book/temp/";
			//static/images/book/
			ClassPathResource cpr=new ClassPathResource("static"+fileUrl);
			try {
				File location=cpr.getFile();
				//해당폴더에 파일이 존재..(잘못선택한 파일)
				for(File element :location.listFiles()) {
					element.delete();
				}
				//파일업로드
				file.transferTo(new File(location, fileName));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return fileUrl+fileName;//"/images/book/temp/"+"파일이름"
		}
	
	
	
	
	//도서감상문 글 삭제
	@Override
	public void bookReviewDelete(long no) {
		reviewRepository.deleteById(no);
	}
	//디테일페이지 출력
	@Override
	public void details(long no,Model model) {
		ReviewDto result = reviewRepository.findById(no)
				.map(ReviewDto::new)
				.orElseThrow();
		model.addAttribute("dto",result);
	}
	/*
	//디테일페이지 출력2
	@Override
	public Review details(long no) {
		Optional<Review> opt=reviewRepository.findById(no);
		return opt.get();
	}
	*/
	//도서감상문 수정
	@Transactional
	@Override
	public void detailUpdate(long no, ReviewDto dto) {
		reviewRepository.findById(no)
						.map(entity->entity.update(dto))
						.get();
	}

	

	

}
