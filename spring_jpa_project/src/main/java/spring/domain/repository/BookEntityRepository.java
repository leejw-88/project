package spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.domain.entity.BookEntity;

public interface BookEntityRepository extends JpaRepository<BookEntity, Long>{

}
