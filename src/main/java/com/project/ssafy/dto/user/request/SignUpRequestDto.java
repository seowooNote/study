package com.project.ssafy.dto.user.request;

import com.project.ssafy.entity.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Data
public class SignUpRequestDto {
    private String email;
    private String password;
    private String name;
    private Character gender;
    private String phone;
    private String nickname;

    public User toUserEntity(BCryptPasswordEncoder passwordEncoder) {
        return User
                .builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .gender(gender)
                .phone(phone)
                .nickname(nickname)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
