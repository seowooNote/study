package com.project.ssafy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String nickname;
    private Character gender;
    private String profile;
    private String statusMessage;
    private String height;
    private String reach;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
