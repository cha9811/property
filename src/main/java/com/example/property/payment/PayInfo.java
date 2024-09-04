package com.example.property.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class PayInfo {

    //컨테이너 체크할것
    //todo : 회원정보 -> 결제번호, 계좌번호, 결제이력, 사용자 index,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pay_id;
    private int research_id;
    private int member_id;
    private boolean payinfo_status;


}
