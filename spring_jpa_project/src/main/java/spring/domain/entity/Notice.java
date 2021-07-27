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
public class Notice extends BaseDate{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long no;//pk
	
	@Column(nullable = false)
	private String title;//제목
	@Column(nullable = false)
	private String content;//내용
	@Column
	private String writer;//작성자
	@Column
	private long view;//조회수

}
