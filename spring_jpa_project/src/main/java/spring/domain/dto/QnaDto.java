package spring.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.domain.entity.QnaEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QnaDto {
	private long no; //pk

	private String writer; //작성자
	private String title; //제목
	private String content; //내용
	private long view; //조회수
	private LocalDateTime createdDate; //(가입,생성) 날짜,시간
	private LocalDateTime updatedDate; //최종 수정날짜,시간
	
	public QnaDto(QnaEntity qnaEntity) {
		no=qnaEntity.getNo();
		writer=qnaEntity.getWriter();
		title=qnaEntity.getTitle();
		content=qnaEntity.getContent();
		view=qnaEntity.getView();
		createdDate=qnaEntity.getCreatedDate();
		updatedDate=qnaEntity.getUpdatedDate();
	}

	public QnaEntity toEntity() {
		return QnaEntity.builder()
				.no(no)
				.writer(writer)
				.title(title)
				.content(content)
				.view(view)
				.build();
				
	}
}
