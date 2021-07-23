package spring.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.domain.entity.BookEntity;

@NoArgsConstructor
@Data
public class BookWriteDto {

	private String title;
	//파일은 일단 수동으로 세팅할께요..
	private String fileName;
	private String fileUrl;
	private long fileSize;
	
	public BookEntity toEntity() {
		return BookEntity.builder()
				.title(title)
				.fileName(fileName)
				.fileUrl(fileUrl)
				.fileSize(fileSize)
				.build();
	}

}
