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
import spring.domain.dto.QnaUpdateDto;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QnaEntity extends BaseDate{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no; //pk
	
	@Column(length = 20,nullable = false)
	private String writer; //작성자
	@Column(length = 100,nullable = false)
	private String title; //제목
	@Column(nullable = false)
	private String content; //내용
	@Column
	private long view; //조회수

	
	public QnaEntity update(QnaUpdateDto dto) {
		title=dto.getTitle();
		content=dto.getContent();
		return this;
	}
}
