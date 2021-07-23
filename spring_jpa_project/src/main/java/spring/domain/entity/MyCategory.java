package spring.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class MyCategory {
	
	@Id
	private int code;
	
	private int first;
	private String fname;
	private int second;
	private String sname;
	private int third;
	private String tname;
	private int detail;
	private String dname;
}
