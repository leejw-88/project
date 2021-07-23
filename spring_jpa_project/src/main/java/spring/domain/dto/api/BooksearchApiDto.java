package spring.domain.dto.api;

import lombok.Data;

@Data
public class BooksearchApiDto {
	Meta meta;
	Documents documents;
	
	@Data
	public class Meta{
		int total_count;//검색된 문서 수
		int pageable_count;//중복된 문서를 제외하고, 처음부터 요청 페이지까지의 노출 가능 문서 수
		boolean is_end;//현재 페이지가 마지막 페이지인지 여부, 값이 false면 page를 증가시켜 다음 페이지를 요청할 수 있음
	}
	@Data
	public class Documents{
		String title;//도서 제목
		String contents;//도서 소개
		String url;//도서 상세 URL
		String isbn;//ISBN10(10자리) 또는 ISBN13(13자리) 형식의 국제 표준 도서번호(International Standard Book Number)
					//ISBN10 또는 ISBN13 중 하나 이상 포함
					//두 값이 모두 제공될 경우 공백(' ')으로 구분
		String[] authors;//도서 저자 리스트
		String publisher;//도서 출판사
		String[] translators;//도서 번역자 리스트
		int price;//도서 정가
		int sale_price;//도서 판매가
		String thumbnail;//도서 표지 미리보기 URL
		String status;//도서 판매 상태 정보 (정상, 품절, 절판 등)
	}
}

