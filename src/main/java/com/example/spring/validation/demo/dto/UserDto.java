package com.example.spring.validation.demo.dto;

import com.example.spring.validation.demo.dto.validator.SignUpDtoCheck;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @SignUpDtoCheck
    public static class UserSignUpReqDto {

        @NotEmpty(message = "닉네임은 필수입니다.")
        private String nickName;    //닉네임

        private String phoneNumber; //전화번호

        @NotEmpty(message = "이메일은 필수입니다.")
        @Email
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

    @Getter
    public static class UserSignUpResDto {

        private String nickName;
        private String phoneNumber;
        private String email;

        @Builder
        public UserSignUpResDto(String nickName, String phoneNumber, String email) {
            this.nickName = nickName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }
    }
}
