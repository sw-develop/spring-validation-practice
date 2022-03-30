package com.example.spring.validation.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {

    @Getter
    @NoArgsConstructor
    public static class UserSignUpReqDto {

        private String nickName;    //닉네임
        private String phoneNumber; //전화번호
        private String email;   //이메일
        private String password;    //비밀번호

        @Builder
        public UserSignUpReqDto(String nickName, String phoneNumber, String email, String password) {
            this.nickName = nickName;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.password = password;
        }
    }
}
