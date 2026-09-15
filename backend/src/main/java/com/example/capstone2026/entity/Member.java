package com.example.capstone2026.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "members")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String userId; // 사용자 아이디

    @Column(nullable = false, length = 100)
    private String password; // 비밀번호

    @Column(nullable = false, length = 50)
    private String name; // 이름

    // --- 아래 메서드 2개를 직접 추가하세요 ---
    public String getUserId() {
        return this.userId;
    }

    public String getPassword() {
        return this.password;
    }
}