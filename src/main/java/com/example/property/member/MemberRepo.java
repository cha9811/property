package com.example.property.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.member_username = :username")
    public Member findByUserName(@Param("username") String username);



}
