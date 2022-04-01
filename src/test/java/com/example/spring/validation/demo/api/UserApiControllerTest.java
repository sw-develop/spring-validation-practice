package com.example.spring.validation.demo.api;

import com.example.spring.validation.demo.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("사용자 회원가입 정상")
    @Test
    void userSignUpNormal() throws Exception {
        //given
        UserDto.UserSignUpReqDto userSignUpReqDto = UserDto.UserSignUpReqDto.builder()
                .nickName("Tiger")
                .phoneNumber("01012341234")
                .email("tiger@gmail.com")
                .password("ttttt").build();

        String requestBody = objectMapper.writeValueAsString(userSignUpReqDto);

        //when, then
        mockMvc.perform(
                post("/v1/user/sign-up")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
        )
//                .andDo(print());
                .andExpect(status().isOk())
                .andExpect(jsonPath("data").exists())
                .andExpect(jsonPath("data.nickName").value("Tiger"))
                .andExpect(jsonPath("data.phoneNumber").value("01012341234"))
                .andExpect(jsonPath("data.email").value("tiger@gmail.com"));
    }

    @DisplayName("닉네임이 없을 때 사용자 회원가입 실패")
    @Test
    void userSignUpFailWithoutNickName() throws Exception {
        //given
        UserDto.UserSignUpReqDto userSignUpReqDto = UserDto.UserSignUpReqDto.builder()
                .phoneNumber("01012341234")
                .email("tiger@gmail.com")
                .password("ttttt").build();

        String requestBody = objectMapper.writeValueAsString(userSignUpReqDto);

        //when, then
        mockMvc.perform(
                post("/v1/user/sign-up")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON)
        )
//                .andDo(print());
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("data").exists())
                .andExpect(jsonPath("data.[0].field").value("nickName"))
                .andExpect(jsonPath("data.[0].defaultMessage").value("닉네임은 필수입니다."));
    }
}
