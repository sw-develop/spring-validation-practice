package com.example.spring.validation.demo.dto;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDtoValidationTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @DisplayName("@NotEmpty - 빈문자열 전송 시 에러 발생")
    @Test
    void notEmptyValidationErrorTest1() {
        //given
        UserDto.UserSignUpReqDto userSignUpReqDto = UserDto.UserSignUpReqDto.builder()
                .nickName("")
                .phoneNumber("021231234")
                .email("1234@gmail.com")
                .password("1234").build();
        //when
        Set<ConstraintViolation<UserDto.UserSignUpReqDto>> violations = validator.validate(userSignUpReqDto);   //유효하지 않은 경우 violations 값을 가지고 있음
        //then
        assertThat(violations).isNotEmpty();
        violations
                .forEach(error -> {
                    assertThat(error.getMessage()).isEqualTo("닉네임은 필수입니다.");
                });
    }

    @DisplayName("@NotEmpty - null 전송 시 에러 발생")
    @Test
    void notEmptyValidationErrorTest2() {
        //given
        UserDto.UserSignUpReqDto userSignUpReqDto = UserDto.UserSignUpReqDto.builder()
                .nickName(null)
                .phoneNumber("021231234")
                .email("1234@gmail.com")
                .password("1234").build();
        //when
        Set<ConstraintViolation<UserDto.UserSignUpReqDto>> violations = validator.validate(userSignUpReqDto);   //유효하지 않은 경우 violations 값을 가지고 있음
        //then
        assertThat(violations).isNotEmpty();
        violations
                .forEach(error -> {
                    assertThat(error.getMessage()).isEqualTo("닉네임은 필수입니다.");
                });
    }

    @DisplayName("@Pattern - 전화번호에 숫자 이외의 값 전송 시 에러 발생")
    @Test
    void patterValidationErrorTest() {
        //given
        UserDto.UserSignUpReqDto userSignUpReqDto = UserDto.UserSignUpReqDto.builder()
                .nickName("Pooh")
                .phoneNumber("02-123-1234")
                .email("1234@gmail.com")
                .password("1234").build();
        //when
        Set<ConstraintViolation<UserDto.UserSignUpReqDto>> violations = validator.validate(userSignUpReqDto);   //유효하지 않은 경우 violations 값을 가지고 있음
        //then
        assertThat(violations).isNotEmpty();
        violations
                .forEach(error -> {
                    assertThat(error.getMessage()).isEqualTo("숫자만 입력해야 합니다.");
                });
    }
}
