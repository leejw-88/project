package spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.dto.CategoryData;
import spring.domain.dto.CategoryDto;
import spring.domain.repository.MyCategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	MyCategoryRepository myCategoryRepository;
	
	@Override
	public void save(CategoryDto dto) {
		//code, 각 번호 존재하지 않습니다.
		int MaxFirst=myCategoryRepository.getMaxValueFirst();
		System.out.println("MaxFirst : "+MaxFirst);
		//myCategoryRepository.save(dto.toEntity());
	}

	
	//1차카테고리 데이터 읽어오기->모델에 담는다(페이지에서 확인 가능)
	@Override
	public void findAllFirst(ModelAndView mv) {
		List<CategoryData> result= myCategoryRepository.getFirstList()
				.stream()
				.map(CategoryData::new)
				.collect(Collectors.toList());
		/*
		for(CategoryData data:result) {
			System.out.println(data);
		}
		*/
		mv.addObject("list",result);
	}

	//2차카테고리 데이터 읽어오기->모델에 담는다(페이지에서 확인 가능)
	@Override
	public void findAllSecond(int first, ModelAndView mv) {
		List<CategoryData> result= myCategoryRepository.getSecondList(first)
				.stream()
				.map(CategoryData::new)
				.collect(Collectors.toList());
	
		mv.addObject("list",result);
	}

	//3차카테고리 데이터 읽어오기->모델에 담는다(페이지에서 확인 가능)
	@Override
	public void findAllThird(int first, int second, ModelAndView mv) {
		List<CategoryData> result= myCategoryRepository.getThirdList(first,second)
				.stream()
				.map(CategoryData::new)
				.collect(Collectors.toList());
	
		mv.addObject("list",result);
	}


	@Override
	public void findAllDetail(int first, int second, int detail, ModelAndView mv) {
		List<CategoryData> result= myCategoryRepository.getDetailList(first,second,detail)
				.stream()
				.map(CategoryData::new)
				.collect(Collectors.toList());
	
		mv.addObject("list",result);
	}

}
