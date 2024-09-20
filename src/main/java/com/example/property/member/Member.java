package com.example.property.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "members", schema = "property")
public class Member {

    //컨테이너 체크할것
    //todo : 회원정보 -> 결제번호, 계좌번호, 결제이력, 사용자 index,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_id;
    private String member_username;
    private String member_email;
    private String member_password;
    private String member_name;
    private String member_phone_number;
    private String member_address;
    private String member_account;

    @Enumerated(EnumType.STRING) // enum 값을 문자열로 DB에 저장
    private MemberRole member_role;
    private Date created_at;


    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", member_username='" + member_username + '\'' +
                ", member_email='" + member_email + '\'' +
                ", member_password='" + member_password + '\'' +
                ", member_name='" + member_name + '\'' +
                ", member_phone_number='" + member_phone_number + '\'' +
                ", member_address='" + member_address + '\'' +
                ", member_account='" + member_account + '\'' +
                ", member_role='" + member_role + '\'' +
                ", created_at=" + created_at +
                '}';
    }


}
