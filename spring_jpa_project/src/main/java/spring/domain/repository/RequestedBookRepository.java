package spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.domain.entity.RequestedBook;

public interface RequestedBookRepository extends JpaRepository<RequestedBook, Long>{

}
