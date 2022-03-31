package com.example.spring.validation.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class UserSignUpReqDto {

        @NotEmpty(message = "닉네임은 필수입니다.")
        private String nickName;    //닉네임

        @NotEmpty @Pattern(regexp = "^[0-9]+$", message = "숫자만 입력해야 합니다.")
        private String phoneNumber; //전화번호

        @NotEmpty(message = "이메일은 필수입니다.")
        private String email;   //이메일

        @NotEmpty(message = "비밀번호는 필수입니다.")
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
