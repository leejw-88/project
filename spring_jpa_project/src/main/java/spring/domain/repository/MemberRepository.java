package spring.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	Optional<Member> findByEmail(String email);

}
