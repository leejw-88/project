package spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.domain.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{

}
