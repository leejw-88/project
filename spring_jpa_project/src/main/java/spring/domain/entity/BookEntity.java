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
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String fileName;
	
	@Column(nullable = false)
	private String fileUrl;
	
	@Column(nullable = false)
	private long fileSize;
}
