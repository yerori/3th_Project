package com.myproject.estore.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.myproject.estore.dto.Role;
import com.myproject.estore.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   private final CustomOAuth2UserService customOAuth2UserService;
   private UserService uService;
   
   @Bean
   public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
   }
   
   @Override
   public void configure(WebSecurity web) throws Exception
   {
       // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
       web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable() 	//csrf토큰 비활성화
               .headers().frameOptions().disable() 
               .and()
                   .authorizeRequests()
                   .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                   .anyRequest().permitAll()
//                   .antMatchers("/api/v1/**").hasRole(Role.USER.name())
//                   .anyRequest().authenticated()
               .and()
                   .logout()
                       .logoutSuccessUrl("/")
               .and()
                   .oauth2Login()
                       .userInfoEndpoint()
                           .userService(customOAuth2UserService);
	   
//		   http.csrf().disable() //csrf 토큰 비활성화 (테스트 시 걸어두는 게 좋음)
//			.authorizeRequests()
//			 // 해당 주소로 들어오면 인증이 필요함 
//			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//			.anyRequest().permitAll() //이 3개 주소가 아니라면 권한이 허용된다. 
//			.and()
//			.formLogin()
//			.loginPage("/user/loginform");
	   
//	   http.authorizeRequests()
       // 페이지 권한 설정
//           .antMatchers("/admin/**").hasRole("ADMIN")
//           .antMatchers("/member/**").hasRole("MEMBER")
//           .antMatchers("/user/**", "/manager/**").authenticated()
//           .anyRequest().authenticated()
//         
//           
//          .and() // 로그아웃 설정
//           .logout()
//           .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//           .logoutSuccessUrl("/")
//           .and() // 로그인 설정
//           .oauth2Login()
//           .userInfoEndpoint()
//           .userService(customOAuth2UserService);
   }
   
//   @Override
//   public void configure(AuthenticationManagerBuilder auth) throws Exception {
//       auth.userDetailsService(uService).passwordEncoder(passwordEncoder());
//   }
   
}
