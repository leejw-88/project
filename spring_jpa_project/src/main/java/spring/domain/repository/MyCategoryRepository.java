package spring.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.domain.entity.MyCategory;

public interface MyCategoryRepository extends JpaRepository<MyCategory, Integer>{

	@Query("select max(first) as maxfirst FROM MyCategory mc")
	int getMaxValueFirst();

	@Query("select distinct first, fname from MyCategory mc")
	List<Object[]> getFirstList();

	@Query("select distinct second, sname from MyCategory mc where first=:firstvalue")
	List<Object[]> getSecondList(@Param("firstvalue") int first);

	@Query("select distinct third, tname from MyCategory mc where first=:firstvalue and second=:secondvalue")
	List<Object[]> getThirdList(@Param("firstvalue")int first,@Param("secondvalue") int second);

	@Query("select distinct detail, dname from MyCategory mc where first=:firstvalue and second=:secondvalue and detail=:detailvalue")
	List<Object[]> getDetailList(@Param("firstvalue") int first,@Param("secondvalue") int second,@Param("detailvalue") int detail);

}
