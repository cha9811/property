package com.example.property.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    public Member getMemberInfo(String member_name){
        Member memberInfo = memberService.getMemberInfoByName(member_name);
        System.out.println(memberInfo);
        return memberInfo;
    }

    @RequestMapping("/customLoginPage")
    public String loginPage() {
        System.out.println("로그인 페이지 이동");
        memberService.getAllUsers();

        return "/member/customLoginPage";
    }

    public void memberInfo(){
        List<Member> member = memberService.getAllUsers();
        for(Member m:member){
            System.out.println("결과" + m);
        }
    }

//    @RequestMapping("/login")
//    public String login(){
//        System.out.println("로그인 실행");
//        return login;
//    }


}
