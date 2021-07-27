package spring.domain.dto.api;

import lombok.Data;

@Data
public class DailyBoxOffice {
	String rnum;
	String rank;
	String rankInten;
	String rankOldAndNew;
	String movieCd;
	String movieNm;
	String openDt;
	String salesAmt;
	String salesShare;
	String salesInten;
	String salesChange;
	String salesAcc;
	String audiCnt;
	String audiInten;
	String audiChange;
	String audiAcc;
	String scrnCnt;
	String showCnt;
}
