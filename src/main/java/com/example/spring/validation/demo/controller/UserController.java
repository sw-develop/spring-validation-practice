package com.example.spring.validation.demo.controller;

import com.example.spring.validation.demo.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/user/sign-up/detail-view")
    public String userSignUpDetailView(Model model) {

        UserDto.UserSignUpReqDto userSignUpReqDto = UserDto.UserSignUpReqDto.builder().build();
        model.addAttribute("userSignUpReqDto", userSignUpReqDto);

        return "user/sign-up";
    }

    //화면에서 등록 버튼 클릭 시 호출
    @PostMapping("/user/sign-up")
    public String userSignUp(UserDto.UserSignUpReqDto userSignUpReqDto, Model model) {
        //회원가입 실패


        //회원가입 성공 (로그인 완료 페이지로 리다이렉션)
        return "redirect:/user/login";
    }
}
