package com.example.property.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MemberService{

    @Autowired
    private MemberRepo memberRepo;




    public List<Member> getAllUsers() {
        System.out.println(memberRepo.findAll());
        return memberRepo.findAll();
    }


    public Member getMemberInfoByName(String name){
        Member member = memberRepo.findByUserName(name);
        return member;
    }




}
