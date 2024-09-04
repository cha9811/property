package com.example.property.home;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    
    @Description("기본 경로")
    @RequestMapping("homePage")
    public String home() {
        System.out.println("홈페이지 이동");
        return "/homePage";
    }





//    @RequestMapping
//    public String gDetailPage(@ResponseBody String id){
//
//
//        return null;
//    }

}
