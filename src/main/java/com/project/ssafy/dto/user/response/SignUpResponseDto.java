package com.project.ssafy.dto.user.response;

import com.project.ssafy.common.ResponseCode;
import com.project.ssafy.common.ResponseMessage;
import com.project.ssafy.dto.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class SignUpResponseDto extends ResponseDto {

    private SignUpResponseDto(String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<?> success() {
        SignUpResponseDto result = new SignUpResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<?> existedUserEmail() {
        SignUpResponseDto result = new SignUpResponseDto(ResponseCode.EXISTED_USER_EMAIL, ResponseMessage.EXISTED_USER_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<?> existedUserPhone() {
        SignUpResponseDto result = new SignUpResponseDto(ResponseCode.EXISTED_USER_PHONE, ResponseMessage.EXISTED_USER_PHONE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<?> existedUserNickname() {
        SignUpResponseDto result = new SignUpResponseDto(ResponseCode.EXISTED_USER_NICKNAME, ResponseMessage.EXISTED_USER_NICKNAME);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
