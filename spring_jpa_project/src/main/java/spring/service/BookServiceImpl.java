package spring.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import spring.domain.dto.BookEntityDto;
import spring.domain.dto.BookWriteDto;
import spring.domain.repository.BookEntityRepository;

@Slf4j
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookEntityRepository bookEntityRepository;
	
	@Override
	public void insert(MultipartFile file, BookWriteDto dto) {
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
				bookEntityRepository.save(dto.toEntity());
	}
	
	@Override
	public void movieList(Model model) {
		List<BookEntityDto> result=bookEntityRepository.findAll().stream()
				.map(BookEntityDto::new)
				.collect(Collectors.toList());
		model.addAttribute("list", result);
	}

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

}
