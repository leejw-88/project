package spring.domain.dto.api;

import java.util.List;

import lombok.Data;

@Data
public class BoxOfficeResult {
	
	String boxofficeType;
	String showRange;
	List<DailyBoxOffice> dailyBoxOfficeList;
}
