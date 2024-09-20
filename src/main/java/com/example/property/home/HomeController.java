package com.example.property.home;

import com.example.property.notice.Notice;
import com.example.property.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private NoticeService noticeService;

    @Description("기본 경로")
    @RequestMapping("/home")
    public String home(Model model) {
        ResponseEntity<List<Notice>> responseEntity = noticeService.getNoticeAll();

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            List<Notice> notices = responseEntity.getBody(); // 공지사항 데이터를 가져옴
            model.addAttribute("notices", notices); // 데이터를 모델에 추가하여 뷰로 전달
        } else if (responseEntity.getStatusCode() == HttpStatus.NO_CONTENT) {
            model.addAttribute("error", "공지사항이 없습니다.");
        } else {
            model.addAttribute("error", "서버 에러가 발생했습니다. 잠시 후 다시 시도해주세요.");
        }

        return "home"; // home.html을 렌더링 (타임리프 템플릿)

    }


//    @RequestMapping
//    public String gDetailPage(@ResponseBody String id){
//
//
//        return null;
//    }

}
