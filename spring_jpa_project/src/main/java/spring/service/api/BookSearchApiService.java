package spring.service.api;

import java.util.List;

import spring.domain.dto.api.BookSearch.Item;

public interface BookSearchApiService {
	
	List<Item> getBookSearchList(String search);
}
