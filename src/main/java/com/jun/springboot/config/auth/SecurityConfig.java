package com.jun.springboot.config.auth;

import com.jun.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable()

                .and()
                .authorizeRequests()   // url 별 권한 관리 설정 => antMatcher 옵션 사용 가능
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()   // 전체 열람 권한 부여
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())   // 해당 주소는 USER 권한을 가진 사람만 열람 가능
                .anyRequest().authenticated()   // 설정된 값들 외의 URL 들은 모두 인증된 사용자(=로그인 O)들에게만 허용

                .and()
                .logout().logoutSuccessUrl("/")  // 로그아웃 기능에 대한 설정의 진입점(로그아웃 성공 시 / 주소로 이동)

                .and()
                .oauth2Login()
                .userInfoEndpoint()    // 로그인 성공 이후 사용자의 정보를 가져올 때의 설정 담당
                .userService(customOAuth2UserService);
    }
}
