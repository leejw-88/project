package spring.domain.dto;

import lombok.Data;
import spring.domain.entity.Member;

@Data
public class MemberRequestDto {

	private String email; //이메일
	private String password; //비밀번호
	private String name; //이름
	private String phone; //전화번호
	private String ip; //ip : request에서 얻어오기
	
    public Member toEntity() {
    	return Member.builder()
    			.email(email)
    			.password(password)
    			.name(name)
    			.phone(phone)
    			.ip(ip)
    			.build();
    }
}
