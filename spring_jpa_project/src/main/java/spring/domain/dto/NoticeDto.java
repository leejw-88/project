package spring.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.domain.entity.Notice;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticeDto {
	private long no;//pk
	
	private String title;//제목
	private String content;//내용
	private String writer;//작성자
	private long view;//조회수
	private LocalDateTime createdDate;//(가입,생성) 날짜,시간
	private LocalDateTime updatedDate;//최종 수정날짜,시간
	
	
	public NoticeDto (Notice notice) {
		no=notice.getNo();
		title=notice.getTitle();
		content=notice.getContent();
		writer=notice.getWriter();
		view=notice.getView();
		createdDate=notice.getCreatedDate();
		updatedDate=notice.getUpdatedDate();
	}
	
	
	
	public Notice toEntity() {
		return Notice.builder()
				.no(no)
				.title(title)
				.content(content)
				.writer(writer)
				.view(view)
				.build();
	}
} 
