package com.example.property.notice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long noticeId;

    @NotBlank(message = "제목은 필수 입력 항목입니다.")
    @Size(min = 5, max = 30, message = "제목은 5자 이상 30자 이하이어야 합니다.")
    private String noticeTitle;

    @NotBlank(message = "내용은 필수 입력 항목입니다.")
    @Size(min = 5, max = 30, message = "은 5자 이상 30자 이하이어야 합니다.")
    private String noticeContent;

    private Timestamp noticeCreateTime;
    private Timestamp noticeModifiedTime;

    @Size(min = 6, max= 10, message = "작성자는 최소 6글자 이상 10글자 이하이어야 합니다.")
    private String noticeWriter;


}
