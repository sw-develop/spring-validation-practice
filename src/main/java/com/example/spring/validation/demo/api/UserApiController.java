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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class UserApiController {

    //POST 회원가입
    @PostMapping("v1/user/sign-up")
    public ResponseEntity<SingleResult<UserDto.UserSignUpResDto>> v1UserSignUp(
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

    //POST 회원가입 - rejectValue() 테스트
    @PostMapping("v2/user/sign-up")
    public ResponseEntity<?> v2UserSignUp(
            @RequestBody @Valid UserDto.UserSignUpReqDto userSignUpReqDto, Errors errors) {

        errors.rejectValue("email", "wrong.value", "이미 등록된 이메일입니다.");   //테스트를 위한 에러 추가

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

    //POST 회원가입 - MethodArgumentNotValidException 예외처리 테스트
    @PostMapping("v3/user/sign-up")
    public ResponseEntity<SingleResult<UserDto.UserSignUpResDto>> v3UserSignUpWithMethodArgumentNotValidException(
            @RequestBody @Valid UserDto.UserSignUpReqDto userSignUpReqDto) {

        UserDto.UserSignUpResDto userSignUpResDto = UserDto.UserSignUpResDto.builder()
                .nickName(userSignUpReqDto.getNickName())
                .phoneNumber(userSignUpReqDto.getPhoneNumber())
                .email(userSignUpReqDto.getEmail()).build();

        SingleResult<UserDto.UserSignUpResDto> result = new SingleResult<>(userSignUpResDto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
