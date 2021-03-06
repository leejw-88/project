package spring.domain.dto.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)//선택한 필드이외 모든요소 제외
@Data
public class BookSearch {
	int total;//검색결과 총 문서수
	int start;//검색결과 문서 시작점
	int display;//검색결과 개수
	List<Item> items;//제목,링크
}
