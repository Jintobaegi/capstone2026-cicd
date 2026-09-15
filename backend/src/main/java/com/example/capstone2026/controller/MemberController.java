package com.example.capstone2026.controller;

import com.example.capstone2026.entity.Member;
import com.example.capstone2026.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:63342")
public class MemberController {

    private final MemberRepository memberRepository;

    // 생성자를 직접 추가 (Lombok 대신 스프링이 이 생성자로 의존성을 주입합니다)
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Member member) {
        try {
            Member savedMember = memberRepository.save(member);
            return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("회원가입 중 오류가 발생했습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Member loginRequest) {
        Optional<Member> member = memberRepository.findByUserId(loginRequest.getUserId());

        if (member.isPresent() && member.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(member.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("아이디 또는 비밀번호가 틀렸습니다.");
        }
    }
}