package spring.domain.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import spring.domain.entity.BookEntity;

@RequiredArgsConstructor
@Data
public class BookEntityDto {

	private long no;
	private String title;
	//파일은 일단 수동으로 세팅할께요..
	private String fileName;
	private String fileUrl;
	private long fileSize;
	
	public BookEntityDto(BookEntity entity) {
		this.no = entity.getNo();
		this.title = entity.getTitle();
		this.fileName = entity.getFileName();
		this.fileUrl = entity.getFileUrl();
		this.fileSize = entity.getFileSize();
	}
}
