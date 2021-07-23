package spring.service;

import org.springframework.web.servlet.ModelAndView;

import spring.domain.dto.CategoryDto;

public interface CategoryService {

	void save(CategoryDto dto);

	void findAllFirst(ModelAndView mv);

	void findAllSecond(int first, ModelAndView mv);

	void findAllThird(int first, int second, ModelAndView mv);

	void findAllDetail(int first, int second, int detail, ModelAndView mv);

}
