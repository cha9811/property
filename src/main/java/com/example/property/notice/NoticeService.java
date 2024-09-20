package com.example.property.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepo noticeRepo;

    public ResponseEntity<List<Notice>> getNoticeAll() {
        List<Notice> notices = noticeRepo.findAll();

        if (notices.isEmpty()) {
            // 데이터가 없을 경우 204 No Content 상태 코드 반환
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // 데이터가 있을 경우 200 OK 상태 코드와 함께 공지사항 리스트 반환
            return new ResponseEntity<>(notices, HttpStatus.OK);
        }
    }

}
