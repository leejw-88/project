package spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.domain.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long>{

}
