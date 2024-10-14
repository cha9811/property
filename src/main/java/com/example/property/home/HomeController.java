package com.example.property.home;

import com.example.property.notice.Notice;
import com.example.property.notice.NoticeService;
import com.example.property.property.Property;
import com.example.property.property.PropertyService;
import com.example.property.property.RegionCode;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Autowired
    private NoticeService noticeService;

    @Autowired
    private PropertyService propertyService;

    @Description("기본 경로")
    @RequestMapping("/home")
    public String home(Model model) throws UnsupportedEncodingException, JAXBException {
        ResponseEntity<List<Notice>> responseEntity = noticeService.getNoticeAll();


        //csv 읽어오기 시작
        List<RegionCode> regionCodes = new ArrayList<>();

        String filePath = "/static/FILE/Region_20231231.csv";
        Resource resource = new ClassPathResource(filePath);

        if (!resource.exists()) {
            logger.error("CSV 파일을 찾을 수 없습니다: {}", filePath);
        }

        try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;   // 최상단 행 건너뛰기 (여기선 1111,1112등 구분을 해ㅜ는code가 될것이다)
                    continue;
                }

                if (line.length < 2 || line[0].trim().isEmpty() || line[1].trim().isEmpty()) {
                    logger.warn("잘못된 형식의 라인 스킵: {}", (Object) line);
                    continue; // 잘못된 형식 스킵
                }

                try {
                    RegionCode region = new RegionCode();
                    region.setRegionNumber(Integer.parseInt(line[0].trim()));
                    region.setRegionName(line[1].trim());
                    regionCodes.add(region);
                } catch (NumberFormatException e) {
                    logger.error("지역번호 파싱 오류: {}", line[0], e);
                }
            }
        } catch (IOException | CsvValidationException e) {
            logger.error("CSV 파일 읽기 중 오류 발생", e);
        }

        System.out.println(regionCodes);

        
        // csv 끝
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            List<Notice> notices = responseEntity.getBody(); // 공지사항 데이터를 가져옴
            model.addAttribute("notices", notices); // 데이터를 모델에 추가하여 뷰로 전달
        } else if (responseEntity.getStatusCode() == HttpStatus.NO_CONTENT) {
            model.addAttribute("error", "공지사항이 없습니다.");
        } else {
            model.addAttribute("error", "서버 에러가 발생했습니다. 잠시 후 다시 시도해주세요.");
        }


        propertyService.fetchAllRealEstateData("11110","202402");

        return "home"; // home.html을 렌더링 (타임리프 템플릿)

    }

}
