package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import spring.domain.dto.MemberDetails;
import spring.domain.repository.MemberRepository;

@Slf4j
@Service
public class MemberDetailsService implements UserDetailsService{

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.debug("DB에 id가 존재하면 정보 읽어오기-------------");
		
		return memberRepository.findByEmail(email).map(MemberDetails::new).orElseThrow();
		//Member entity=memberRepository.findByEmail(email).orElseThrow();
		//return new MemberDetails(entity.getEmail(),entity.getPassword(),entity.getRoles().stream().map(role->new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet()));
	}
	
}
