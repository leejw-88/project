package spring.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.dto.GoodsDto;
import spring.domain.dto.GoodsInsertDto;
import spring.domain.repository.GoodsRepository;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	GoodsRepository goodsRepository;
	
	@Override
	public void saveAndUpload(GoodsInsertDto dto) {
		goodsRepository.save(dto.toEntity());
		
	}

	@Override
	public void getlist(ModelAndView mv) {
		mv.addObject("list",goodsRepository.findAll().stream()
				.map(GoodsDto::new)
				.collect(Collectors.toList()));
		
	}

}
