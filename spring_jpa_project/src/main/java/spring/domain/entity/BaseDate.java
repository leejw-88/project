package spring.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class BaseDate {
	//(가입,생성) 날짜,시간
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;
	//최종 수정날짜,시간
	@LastModifiedDate
	private LocalDateTime updatedDate;
}
