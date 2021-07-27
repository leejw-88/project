package spring.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.domain.dto.ReviewDto;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review extends BaseDate{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long no;//번호
	@Column(nullable = false)
	private String bookName;//도서명
	@Column
	private String author; //책 저자
	@Column(nullable = false)
	private String title;//제목
	@Column(nullable = false)
	private String content;//내용
	@Column
	private String writer;//작성자
	@Column
	private long view;//조회수
	
	@Column(nullable = false)
	private String fileName;
	@Column(nullable = false)
	private String fileUrl;
	@Column(nullable = false)
	private long fileSize;
	
	
	public Review update(ReviewDto dto) {
		bookName=dto.getBookName();
		author=dto.getAuthor();
		title=dto.getTitle();
		content=dto.getContent();
		return this;
	}



	
}
