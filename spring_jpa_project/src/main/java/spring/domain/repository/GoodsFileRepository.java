package spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.domain.entity.GoodsFile;

public interface GoodsFileRepository extends JpaRepository<GoodsFile, Long>{

}
