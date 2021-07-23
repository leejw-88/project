package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(
						"/resources/**", "/error","/movie/**",
						"/","/post/**",
						"/log/**",
						"/board/**",
						"/common/**",
						"/member/**")
					.permitAll()//모두 접근가능
				.antMatchers("/user/**")
					.hasRole("USER")//USER권한이상 접근가능
				.antMatchers("/admin/**")
					.hasRole("ADMIN")//ADMIN권한이상 접근가능
				.anyRequest()//위 설정된 이외 나머지경로
					.authenticated();//인증권한이 있어야 접근가능
		http.formLogin()
				.loginPage("/log/login")
				.loginProcessingUrl("/member/login")
				.usernameParameter("email") //username
				.passwordParameter("pass");//password
		
		http.csrf().disable();
		http.logout()
				.logoutSuccessUrl("/");
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		//스프링 시큐리티 적용 무시
		web.ignoring()
			.antMatchers("/css/**","/js/**","/images/**");
	}
	
}
