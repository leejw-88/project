package spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.domain.entity.MyCategory;
import spring.domain.repository.MyCategoryRepository;

@SpringBootTest
class SpringJpaProjectApplicationTests {
	@Autowired
	MyCategoryRepository myCategoryRepository;
	
	//@Test
	void 카테고리예제입력() {
		MyCategory entity=MyCategory.builder()
				.code(10101112)
				.first(10000000)
				.fname("식품")
				.second(100000)
				.sname("농산")
				.third(1100)
				.tname("쌀")
				.detail(12)
				.dname("현미")
				//.third(1000)
				//.tname("과일")
				//.detail(12)
				//.dname("사과")
				.build();
		myCategoryRepository.save(entity);
	}

}
