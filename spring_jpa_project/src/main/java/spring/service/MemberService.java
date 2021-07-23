package spring.service;

import org.springframework.ui.Model;

import spring.domain.dto.MemberRequestDto;

public interface MemberService {

	void join(MemberRequestDto dto, Model model);

	boolean idCheck(String id);
	
}
