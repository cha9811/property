//package com.example.property.security;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component // 빈 등록
//public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
//
//
////    public CustomLoginSuccessHandler(GenerateToken generateToken) {
////        this.generateToken = generateToken;
////    }
//
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
//            throws IOException, ServletException {
//
//
////        String token = generateToken.generateTokens(auth); // 가정: generateTokens는 토큰 생성 메서드
//        //로그인 문제업싱 실행되었음
//        // 토큰을 헤더에 추가
//        System.out.println("로그인 실행");
//        response.addHeader("Authorization", "Bearer 나중에 설정해주기" );
//        response.sendRedirect("/homePage");
//
//
//    }
//}