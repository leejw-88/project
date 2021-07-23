package spring.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import spring.domain.dto.BookWriteDto;

public interface BookService {

	void movieList(Model model);

	String uploadTempFile(MultipartFile file);

	void insert(MultipartFile file, BookWriteDto dto);

}
