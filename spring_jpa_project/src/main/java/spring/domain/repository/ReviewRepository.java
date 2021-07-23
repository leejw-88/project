package spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.domain.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
