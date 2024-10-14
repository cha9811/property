package com.example.property.property;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import java.util.Collections;
import java.util.List;



import org.springframework.http.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

//@Service
@Component
@PropertySource("classpath:test.properties")
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;


    @Value("${api.serviceKey}")
    private String serviceKey;

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "https://apis.data.go.kr/1613000/RTMSDataSvcRHTrade";
    private final String apiUri = "/getRTMSDataSvcRHTrade";
//    String correctedServiceKey = serviceKey.replace("+", "%2B");

    // API URL을 만드는 메서드
    private String makeUrl(String lawdCd, String dealYmd) throws UnsupportedEncodingException {
        String correctedServiceKey = serviceKey.replace("+", "%2B");

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + apiUri)
                .queryParam("LAWD_CD", lawdCd)   // 지역 코드
                .queryParam("DEAL_YMD", dealYmd)  // 거래 연월
                .queryParam("numOfRows", 100)   // 한 번에 가져올 데이터 개수
                .build(false) // 인코딩하지 않음
                .toUriString();
        url += "&serviceKey=" + correctedServiceKey;
        return url;

    }


    // 실제 API 호출 메서드
    public void  fetchAllRealEstateData(String lawdCd, String dealYmd) throws UnsupportedEncodingException, JAXBException {
        try {
            String url = makeUrl(lawdCd, dealYmd);
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "Mozilla/5.0");
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            String jsonResponse = responseEntity.getBody();

            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponse apiResponse = objectMapper.readValue(jsonResponse, ApiResponse.class);

            if (apiResponse != null && apiResponse.getResponse() != null) {
                Body body = apiResponse.getResponse().getBody();
                if (body != null && body.getItems() != null) {
                    List<Item> items = body.getItems().getItem();
                    for (Item item : items) {
                        Property property = mapItemToProperty(item);
//                        propertyRepository.save(property);
                    }
                } else {
                    System.out.println("No data available.");
                }
            } else {
                System.out.println("Invalid response.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Property mapItemToProperty(Item item) {
        Property property = new Property();
        property.setBuildYear(item.getBuildYear()); // int
        property.setBuyerGbn(item.getBuyerGbn()); // String
        property.setCdealDay(item.getCdealDay()); // String
        property.setCdealType(item.getCdealType()); // String
        property.setDealAmount(item.getDealAmount()); // String
        property.setDealDay(item.getDealDay()); // int
        property.setDealMonth(item.getDealMonth()); // int
        property.setDealYear(item.getDealYear()); // int
        property.setDealingGbn(item.getDealingGbn()); // String
        property.setEstateAgentSggNm(item.getEstateAgentSggNm()); // String
        property.setExcluUseAr(item.getExcluUseAr()); // double
        property.setFloor(item.getFloor()); // int
        property.setHouseType(item.getHouseType()); // String
        property.setJibun(item.getJibun()); // String
        property.setLandAr(item.getLandAr()); // double
        property.setMhouseNm(item.getMhouseNm()); // String
        property.setRgstDate(item.getRgstDate()); // String
        property.setSggCd(item.getSggCd()); // int
        property.setSlerGbn(item.getSlerGbn()); // String
        property.setUmdNm(item.getUmdNm()); // String
        return property;
    }


}
