package com.example.spring.validation.demo.dto.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class PatternUtils {

    public final String REGEX_PHONE = "[0-9]{8,11}$";

    public final String REGEX_PASSWORD = "[a-zA-Z]{4,6}";

    /**
     * 전화번호 형식 체크 - 숫자만 가능, 8~11자
     */
    public boolean phoneNumberMatch(String phoneNumber) {

        if(StringUtils.isBlank(phoneNumber)) {
            return false;
        }

        Pattern pattern = Pattern.compile(REGEX_PHONE);
        return pattern.matcher(phoneNumber).matches();
    }

    /**
     * 비밀번호 형식 체크 - 영문자만 가능, 4~6자
     */
    public boolean passwordMatch(String password) {

        if(StringUtils.isBlank(password)) {
            return false;
        }

        Pattern pattern = Pattern.compile(REGEX_PASSWORD);
        return pattern.matcher(password).matches();
    }

}
