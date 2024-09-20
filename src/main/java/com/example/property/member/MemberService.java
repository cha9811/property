package com.example.property.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MemberService{

    @Autowired
    private MemberRepo memberRepo;


//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    public MemberService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }


    public List<Member> getAllUsers() {
        System.out.println(memberRepo.findAll());
        return memberRepo.findAll();
    }


    public Member getMemberInfoByName(String name){
        Member member = memberRepo.findByUserName(name);
        return member;
    }

    public void signUp(Member member){
//        String encodePassWord = passwordEncoder.encode(member.getMember_password());
//        member.setMember_password(encodePassWord);
        memberRepo.save(member);
    }



}
