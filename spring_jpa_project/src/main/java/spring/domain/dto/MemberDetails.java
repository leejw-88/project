package spring.domain.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import spring.domain.entity.Member;

@Getter
public class MemberDetails extends User{
	private String name;
	private String phone;
	
	public MemberDetails(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		//super(); //noArgsConstructor 존재하지않습니다.
	}
	
	
	public MemberDetails(Member entity) {
		super(entity.getEmail(), entity.getPassword(), 
				entity.getRoles().stream()
				.map(role->new SimpleGrantedAuthority(role.getRole()))
				.collect(Collectors.toSet()));
		name=entity.getName();
		phone=entity.getPhone();
		//super(); //noArgsConstructor 존재하지않습니다.
	}
	
}
