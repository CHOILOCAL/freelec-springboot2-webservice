package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable()// h2-console 화면 사용을 위해
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll() // 전체 열람 가능
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER 권한을 가진 사람만 가능
                .anyRequest().authenticated() // 설정된 값 이외의 나머지 URL '인증된 사용자만'
                .and().logout().logoutSuccessUrl("/") // logout시 "/" 주소로 redirect
                .and().oauth2Login().userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                .userService(customOAuth2UserService); // 소셜 로그인 성공 이후 후속 조치 진행할 UserService 인터페이스의 구현체, 리소스 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시

    }
}
