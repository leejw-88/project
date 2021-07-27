package spring.domain.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)//선택한 필드이외 모든요소 제외
@Data
public class Item {
	String title;//도서제목
	String image;//이미지
	String author;//저자
	String publisher;//출판사
	String description;//요약정보
}
