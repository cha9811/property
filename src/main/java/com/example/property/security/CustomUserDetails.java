package com.example.property.security;

import com.example.property.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    private Member member;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities; //websocket의 userAut로 user_id를 추출하기 위해 필요함
    private int userId; // 사용자 고유 ID 또는 인덱스
    private String member_role;


    public CustomUserDetails(Member member) {
        this.member = member;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
