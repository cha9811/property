package com.example.property.security;

import com.example.property.member.Member;
import com.example.property.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Member member = memberService.getMemberInfoByName(username);

    if(member == null){
        throw new UsernameNotFoundException(username);
    }

        return new CustomUserDetails(member);
    }
}
