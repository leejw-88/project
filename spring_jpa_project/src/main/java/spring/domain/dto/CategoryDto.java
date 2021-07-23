package spring.domain.dto;

import lombok.Data;
import spring.domain.entity.MyCategory;

@Data
public class CategoryDto {
	private String fname;
	private String sname;
	private String tname;
	private String dname;
	
	public MyCategory toEntity() {
		return MyCategory.builder()
				.first(0)
				.second(0)
				.third(0)
				.detail(0)
				.build();
	}

}
