package spring.service.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import spring.domain.dto.api.DailyBoxOffice;
import spring.domain.dto.api.ResultJSONData;

@Service
public class MovieApiServiceImpl implements MovieApiService {
	@Autowired
	HttpServletRequest request;
	@Override
	public List<DailyBoxOffice> getDailyMovieList() {
		//7b1cefa94185fbe35696504fb9222c40
		//영화진흥위원회 오픈 api
		String targetDt=request.getParameter("targetDt")==""?"20210721":request.getParameter("targetDt"); //(필수)조회하고자 하는 날짜를 yyyymmdd 형식으로 입력합니다.
		String itemPerPage=request.getParameter("itemPerPage")==""?"10":request.getParameter("itemPerPage");//결과 ROW 의 개수를 지정합니다.(default : “10”, 최대 : “10“)
		String multiMovieYn=null;//“Y” : 다양성 영화 “N” : 상업영화 (default : 전체)
		String repNationCd=null;//“K: : 한국영화 “F” : 외국영화 (default : 전체)
		String wideAreaCd=null;//상영지역별로 조회할 수 있으며, 지역코드는 공통코드 조회 서비스에서 “0105000000” 로서 조회된 지역코드입니다. (default : 전체)
		String key="7b1cefa94185fbe35696504fb9222c40";
		KobisOpenAPIRestService kobisService=new KobisOpenAPIRestService(key);
		
		try {
			String jsonResult=kobisService.getDailyBoxOffice(true, targetDt, itemPerPage, multiMovieYn, repNationCd, wideAreaCd);
			//System.out.println(jsonResult);
			//문자열데이터를->class로 매핑
			
			ObjectMapper mapper=new ObjectMapper();
			ResultJSONData resultData=mapper.readValue(jsonResult, ResultJSONData.class);
			//System.out.println(resultData);
			
			return resultData.getBoxOfficeResult().getDailyBoxOfficeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
