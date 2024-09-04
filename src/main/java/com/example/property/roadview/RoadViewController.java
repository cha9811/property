package com.example.property.roadview;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoadViewController {

    
    @Description("로드뷰 경로")
    @RequestMapping("roadView")
    public String home() {

        return "home";
    }
}
