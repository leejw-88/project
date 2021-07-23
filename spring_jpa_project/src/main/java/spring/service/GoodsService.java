package spring.service;

import org.springframework.web.servlet.ModelAndView;

import spring.domain.dto.GoodsInsertDto;

public interface GoodsService {

	void saveAndUpload(GoodsInsertDto dto);

	void getlist(ModelAndView mv);

}
