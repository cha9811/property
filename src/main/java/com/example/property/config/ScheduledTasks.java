/*
package com.example.property.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ScheduledTasks {

    @Autowired
    private RestTemplate restTemplate;

//    @Value("${api.serviceKey}")
    @Scheduled(cron = "0 0 1 * * ?")  // 매일 새벽 1시에 실행
    public String fetchData(String lawdCd, String dealYmd, String serviceKey) {
        String baseUrl = "https://apis.data.go.kr/1613000/RTMSDataSvcRHTrade/getRTMSDataSvcRHTrade";
        
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("LAWD_CD", lawdCd)
                .queryParam("DEAL_YMD", dealYmd)
                .queryParam("serviceKey", serviceKey)
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

}
*/
