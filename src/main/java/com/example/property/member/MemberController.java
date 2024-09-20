package com.example.property.member;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
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
//        memberService.getAllUsers();

        return "/member/customLoginPage";
    }

    public void memberInfo(){
        List<Member> member = memberService.getAllUsers();
        for(Member m:member){
            System.out.println("결과" + m);
        }
    }

    @RequestMapping("/signUp")
    public String memberSighUp(@ModelAttribute Member member){
        System.out.println("회원가입 진행");
        memberService.signUp(member);
        log.debug("-회원가입 실행-");
        return "redirect:/login";
    }
   /* @RequestMapping("/login")
    public String login(){
        System.out.println("로그인 실행");
        return custo;
    }*/


}
