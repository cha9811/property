package com.example.property.security;

import com.example.property.member.Member;
import com.example.property.member.MemberRepo;
import com.example.property.member.MemberRole;
import com.example.property.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.property.member.MemberRole.Nomal;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepo memberRepo;



    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //유저 정보 탐색
        Member member = memberRepo.findByUserName(username);
        System.out.println("DB 암호화된 비밀번호: " + member.getMember_password());


        if (member == null) {
            throw new UsernameNotFoundException(username);
        }

        //권한설정
        if (member.getMember_role() == Nomal) {
            member.setMember_role(Nomal);
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(username);


        return new CustomUserDetails(member);
    }*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 유저 정보 탐색
        Member member = memberRepo.findByUserName(username);
        System.out.println("내이름은"+username);
        System.out.println("서비스"+member);
        if (member == null) {
            throw new UsernameNotFoundException(username);
        }

//        // member_role이 null인지 확인
//        if (member.getMember_role() == null) {
//            throw new UsernameNotFoundException("Role is null for user: " + username);
//        }

        // 권한 설정 (필요에 따라 수정)
        CustomUserDetails userDetails = new CustomUserDetails(member);
        System.out.println("userDetails"+userDetails);
        return userDetails;
    }

}
