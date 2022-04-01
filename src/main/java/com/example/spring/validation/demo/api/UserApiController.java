package com.example.spring.validation.demo.api;

import com.example.spring.validation.demo.api.exception.ApiParamNotValidException;
import com.example.spring.validation.demo.dto.UserDto;
import com.example.spring.validation.demo.payload.response.SingleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/v1")
@RestController
public class UserApiController {

    //POST 회원가입
    @PostMapping("/user/sign-up")
    public ResponseEntity<SingleResult<UserDto.UserSignUpResDto>> userSignUp(
            @RequestBody @Valid UserDto.UserSignUpReqDto userSignUpReqDto, Errors errors) {

        if(errors.hasErrors()) {
            throw new ApiParamNotValidException(errors);
        }

        UserDto.UserSignUpResDto userSignUpResDto = UserDto.UserSignUpResDto.builder()
                .nickName(userSignUpReqDto.getNickName())
                .phoneNumber(userSignUpReqDto.getPhoneNumber())
                .email(userSignUpReqDto.getEmail()).build();

        SingleResult<UserDto.UserSignUpResDto> result = new SingleResult<>(userSignUpResDto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
