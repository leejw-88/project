package spring.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.domain.dto.MemberRequestDto;
import spring.domain.entity.Member;
import spring.domain.entity.MemberRole;
import spring.domain.repository.MemberRepository;

@Service
public class MemberJoinService implements MemberService{

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private MemberRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void join(MemberRequestDto dto, Model model) {
		String ip=request.getRemoteAddr();
		dto.setIp(ip);	
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		//Role 적용
		Member entity=dto.toEntity();
		entity.addRole(MemberRole.USER);
		
		repository.save(entity);
		model.addAttribute("welcome",dto.getName()+"님! 회원가입을 축하합니다.");
	}

	@Override
	public boolean idCheck(String email) {
		Optional<Member> result=repository.findByEmail(email);
		return result.isEmpty();
		
	}

}
