package com.project.ssafy.service;

import com.project.ssafy.dto.user.request.SignUpRequestDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<?> signUp(SignUpRequestDto signUpRequestDto);
}
