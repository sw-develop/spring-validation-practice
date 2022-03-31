package com.example.spring.validation.demo.dto.validator;

import com.example.spring.validation.demo.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SignUpDtoCheckValidator implements ConstraintValidator<SignUpDtoCheck, UserDto.UserSignUpReqDto> {

    @Override
    public void initialize(SignUpDtoCheck constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserDto.UserSignUpReqDto value, ConstraintValidatorContext context) {

        int invalidCount = 0;

        PatternUtils patternUtils = new PatternUtils();

        if(!patternUtils.phoneNumberMatch(value.getPhoneNumber())) {
            addConstraintViolation(context, "전화번호는 숫자 8~11자만 가능합니다.", "phoneNumber");
            invalidCount++;
        }

        if (!patternUtils.passwordMatch(value.getPassword())) {
            addConstraintViolation(context, "비밀번호는 영문자 4~6자만 가능합니다.", "password");
            invalidCount++;
        }

        return invalidCount == 0;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String errorMessage, String firstNode) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode(firstNode)
                .addConstraintViolation();
    }

}
