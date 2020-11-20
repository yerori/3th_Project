package com.myproject.estore.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.myproject.estore.dto.Role;
import com.myproject.estore.service.AuthService;
import com.myproject.estore.service.ShopService;
import com.myproject.estore.service.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   private final CustomOAuth2UserService customOAuth2UserService;

   private final AuthService aService;
   
   @Bean	//BCypassword가 PasswordEncoder 하위 클래스라, 오류 
   public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
   }
   
   @Override
   public void configure(WebSecurity web) throws Exception
   {
       // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
       web.ignoring().antMatchers("/assets/**");
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
       		.csrf().disable() 	//csrf토큰 비활성화
               .headers().frameOptions().disable() 
               .and()
                   .authorizeRequests()
                   .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                   .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                   .antMatchers("/manager/**").access("hasRole('ROLE_MANAGER')")
                   .antMatchers("/**").permitAll()
               .and() 
                   .formLogin() // 로그인 관한 설정
                  // .loginPage("/loginform") // 로그인 페이지 링크
                   .defaultSuccessUrl("/")   //로그인 성공 후 리다이렉트할 주소 
                //   .failureHandler(authenticationFailureHandler)
               .and()
                   .logout()
                   	 //  .logoutSuccessUrl("/logout")
                       .logoutSuccessUrl("/")
                       .invalidateHttpSession(true) //세션 날리기 true
               .and()
                   .oauth2Login()
                       .userInfoEndpoint()                  
                           .userService(customOAuth2UserService);
       

   }
   
   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
	   System.out.println(passwordEncoder());
	   System.out.println(aService);
	   
       auth.userDetailsService(aService).passwordEncoder(passwordEncoder());
   }

   
}
