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

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RequestedBook extends BaseDate{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no; //pk

	@Column(nullable = false)
	private String booktit; //책 제목
	@Column
	private String author; //책 저자
	@Column
	private String publisher; //출판사
	@Column
	private String writer; //작성자
	@Column(nullable = false)
	private String content; //내용
	@Column
	private long view; //조회수

}
