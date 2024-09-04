package com.example.property.config;


import com.example.property.security.CustomLoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {



    @Bean
    public CustomLoginSuccessHandler customLoginSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize  -> authorize
//                                .requestMatchers("*").permitAll() // 인증 없이 접근 허용
                                .requestMatchers("customLoginPage","/CSS/**","/JS/public/**").permitAll() // 여기서 모든 사용자의 접근을 허가

//                        .requestMatchers("*/","css/**","/","*","/loginPage","/login","login","loginPage").permitAll()
                                .anyRequest().authenticated()
//                                .anyRequest().permitAll()  // 모든 요청에 대해 접근 허용

                )
                .formLogin(formLogin -> formLogin
//                        .loginPage("/loginPage")
                        .loginPage("/customLoginPage")
                        .defaultSuccessUrl("/home", true) // 로그인 성공 후 리다이렉트할 URL 설정
                        .usernameParameter("member_name") //front에서 보내는 값을 해당 값으로 지정
                        .passwordParameter("password")
                        .loginProcessingUrl("/login") // 로그인 처리 경로 지정
                        .successHandler(customLoginSuccessHandler()) // 로그인 성공 핸들러
//                        .failureHandler(customAuthenticationFailureHandler()) // 로그인 실패 핸들러
                        .permitAll()

                )
                .logout((logout) -> logout
                        .logoutUrl("/logout") // 로그아웃 처리 경로 지정
                        .logoutSuccessUrl("/loginPage") // 로그아웃 성공 시 리다이렉트 경로 지정
                        .permitAll()
                )
                .csrf(csrfConfig -> csrfConfig.disable()); // CSRF 보호 비활성화 (테스트 목적)


//                .httpBasic(withDefaults());
        return http.build();
    }

}
