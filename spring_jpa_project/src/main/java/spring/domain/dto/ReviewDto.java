package spring.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.domain.entity.Review;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDto {
	private long no;//번호
	private String bookName;//도서명
	private String author; //책 저자
	private String title;//제목
	private String content;//내용
	private String writer;//작성자
	private long view;//조회수
	private LocalDateTime createdDate;//생성일
	private LocalDateTime updatedDate;//수정일
	//파일은 일단 수동으로 세팅할께요..
	private String fileName;
	private String fileUrl;
	private long fileSize;
	
	public ReviewDto (Review review) {
		no=review.getNo();
		bookName=review.getBookName();
		author=review.getAuthor();
		title=review.getTitle();
		content=review.getContent();
		writer=review.getWriter();
		view=review.getView();
		createdDate=review.getCreatedDate();
		updatedDate=review.getUpdatedDate();
		fileName=review.getFileName();
		fileUrl=review.getFileUrl();
		fileSize=review.getFileSize();
	}
	
	public Review toEntity() {
		return Review.builder()
				.no(no)
				.bookName(bookName)
				.author(author)
				.title(title)
				.content(content)
				.writer(writer)
				.view(view)
				.fileName(fileName)
				.fileUrl(fileUrl)
				.fileSize(fileSize)
				.build();
	}
}
