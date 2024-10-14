package com.example.property.property;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertyContorller {

    
    @Description("로드뷰 경로")
    @RequestMapping("roadView")
    public String home() {

        return "home";
    }
}
