package spring.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.domain.entity.VisualEntity;

@NoArgsConstructor
@Data
public class VisualDto {
	private long no;
	private String title;
	private String link;
	//MultipartFile file;
	
	private String fileName;
	private String fileUrl;
	private long fileSize;

	public VisualEntity toEntity() {
		return VisualEntity
				.builder()
				.title(title)
				.link(link)
				.fileName(fileName)
				.fileUrl(fileUrl)
				.fileSize(fileSize)
				.build();
	}

	public VisualDto(VisualEntity entity) {

		this.no =entity.getNo();
		this.title =entity.getTitle();
		this.link =entity.getLink();
		this.fileName =entity.getFileName();
		this.fileUrl =entity.getFileUrl();
		this.fileSize =entity.getFileSize();
	}
	
	
}
