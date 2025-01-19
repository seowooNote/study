package com.project.ssafy.service.serviceImpl;

import com.project.ssafy.dto.user.request.SignUpRequestDto;
import com.project.ssafy.dto.user.response.SignUpResponseDto;
import com.project.ssafy.entity.RoleRegister;
import com.project.ssafy.entity.User;
import com.project.ssafy.repository.RoleRegisterRepository;
import com.project.ssafy.repository.UserRepository;
import com.project.ssafy.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRegisterRepository roleRegisterRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> signUp(SignUpRequestDto signUpRequestDto) {
        // 1) 해당 사용자의 입력 이메일이 이미 존재하는 계정인지 확인
        User existedUser = userRepository.findByEmail(signUpRequestDto.getEmail());
        if(existedUser != null) return SignUpResponseDto.existedUserEmail();
        // 2) 해당 사용자의 입력 연락처가 이미 존재하는 계정인지 확인
        User existedUserPhone = userRepository.findByPhone(signUpRequestDto.getPhone());
        if(existedUserPhone != null) return SignUpResponseDto.existedUserPhone();
        // 3) 해당 사용자의 입력 닉네임이 이미 존재하는 계정인지 확인
        User existedUserNickname = userRepository.findByNickname(signUpRequestDto.getNickname());
        if(existedUserNickname != null) return SignUpResponseDto.existedUserNickname();

        // 1, 2, 3 해당 사항이 없다면 정상적으로 회원가입 진행
        userRepository.save(signUpRequestDto.toUserEntity(passwordEncoder));

        // role_register 테이블에도 해당 사항 등록
        User saveUser = userRepository.findByEmail(signUpRequestDto.getEmail());
        roleRegisterRepository.save(RoleRegister
                .builder()
                .userId(saveUser.getUserId())
                .roleId(2L)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build());
        return SignUpResponseDto.success();
    }
}
