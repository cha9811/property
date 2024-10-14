package com.example.property.property;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "propertys")
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private int propertyID;

    @Column(name = "umd_nm")
    private String umdNm;

    @Column(name = "mhouse_nm")
    private String mhouseNm;

    @Column(name = "jibun")
    private String jibun;

    @Column(name = "build_year")
    private String buildYear;

    @Column(name = "exclu_use_ar")
    private String excluUseAr;

    @Column(name = "land_ar")
    private String landAr;

    @Column(name = "deal_year")
    private String dealYear;

    @Column(name = "deal_month")
    private String dealMonth;

    @Column(name = "deal_day")
    private String dealDay;

    @Column(name = "deal_amount")
    private String dealAmount;

    @Column(name = "floor")
    private String floor;

    @Column(name = "dealing_gbn")
    private String dealingGbn;

    @Column(name = "estate_agent_sgg_nm")
    private String estateAgentSggNm;

    @Column(name = "rgst_date")
    private String rgstDate;

    @Column(name = "sler_gbn")
    private String slerGbn;

    @Column(name = "buyer_gbn")
    private String buyerGbn;

    @Column(name = "house_type")
    private String houseType;

    @Column(name = "cdeal_type")
    private String cdealType;

    @Column(name = "sgg_Cd")
    private String sggCd;

    @Column(name = "cdeal_Day")
    private String cdealDay;




}