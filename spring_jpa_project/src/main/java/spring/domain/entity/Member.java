package spring.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Member_pf")
@Entity
public class Member extends BaseDate{
	@Id
	private String email; //이메일 = username값
	
	@Column(nullable = false)
	private String password; //비밀번호
	@Column
	private String name; //이름
	@Column
	private String phone; //전화번호
	@Column
	private String ip; //ip
	
	
	@Enumerated(EnumType.STRING) //DB에 적용시 문자열로 저장(default숫자)
	@ElementCollection(fetch = FetchType.EAGER)
	@Builder.Default
	private Set<MemberRole> roles=new HashSet<MemberRole>();
	public void addRole(MemberRole role) {
		roles.add(role);
	}
	
}
