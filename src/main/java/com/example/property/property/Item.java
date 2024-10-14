package com.example.property.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    @JsonProperty("buildYear")
    private String buildYear; // INTEGER

    @JsonProperty("buyerGbn")
    private String buyerGbn; // VARCHAR

    @JsonProperty("cdealDay")
    private String cdealDay; // VARCHAR

    @JsonProperty("cdealType")
    private String cdealType; // VARCHAR

    @JsonProperty("dealAmount")
    private String dealAmount; // VARCHAR (금액 형식에 따라 String 사용)

    @JsonProperty("dealDay")
    private String dealDay; // INTEGER

    @JsonProperty("dealMonth")
    private String dealMonth; // INTEGER

    @JsonProperty("dealYear")
    private String dealYear; // INTEGER

    @JsonProperty("dealingGbn")
    private String dealingGbn; // VARCHAR

    @JsonProperty("estateAgentSggNm")
    private String estateAgentSggNm; // VARCHAR

    @JsonProperty("excluUseAr")
    private String excluUseAr; // DOUBLE PRECISION

    @JsonProperty("floor")
    private String floor; // INTEGER

    @JsonProperty("houseType")
    private String houseType; // VARCHAR

    @JsonProperty("jibun")
    private String jibun; // VARCHAR (일부 JSON에서는 정수, 이를 String으로 통일)

    @JsonProperty("landAr")
    private String landAr; // DOUBLE PRECISION

    @JsonProperty("mhouseNm")
    private String mhouseNm; // VARCHAR

    @JsonProperty("rgstDate")
    private String rgstDate; // VARCHAR (날짜 형식에 따라 String 사용)

    @JsonProperty("sggCd")
    private String sggCd; // INTEGER

    @JsonProperty("slerGbn")
    private String slerGbn; // VARCHAR

    @JsonProperty("umdNm")
    private String umdNm; // VARCHAR

}