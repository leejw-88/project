package spring.service.api;

import java.util.List;

import spring.domain.dto.api.DailyBoxOffice;

public interface MovieApiService {

	List<DailyBoxOffice> getDailyMovieList();

}
