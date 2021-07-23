package spring.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.domain.entity.RequestedBook;

@NoArgsConstructor
@Data
public class RequestedBookDto {
	private long no; //pk
	private String booktit; //책 제목
	private String author; //책 저자
	private String publisher; //출판사
	private String writer; //작성자
	private String content; //내용
	private long view; //조회수
	private LocalDateTime createdDate; //(가입,생성) 날짜,시간
	private LocalDateTime updatedDate; //최종 수정날짜,시간
	
	public RequestedBookDto(RequestedBook book) {
		no=book.getNo();
		booktit=book.getBooktit();
		author=book.getAuthor();
		publisher=book.getPublisher();
		writer=book.getWriter();
		content=book.getContent();
		view=book.getView();
		createdDate=book.getCreatedDate();
		updatedDate=book.getUpdatedDate();
	}

	public RequestedBook toEntity() {
		return RequestedBook.builder()
				.no(no)
				.booktit(booktit)
				.author(author)
				.publisher(publisher)
				.writer(writer)
				.content(content)
				.view(view)
				.build();
				
	}
}
