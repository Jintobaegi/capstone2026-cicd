package com.example.capstone2026.repository;

import com.example.capstone2026.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 로그인 기능을 위해 아이디로 회원 정보를 찾는 쿼리 메서드 정의
    Optional<Member> findByUserId(String userId);

}