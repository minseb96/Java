package com.example.sns.controller.user;

import com.example.sns.domain.user.User;
import com.example.sns.dto.user.CreateUserDto;
import com.example.sns.dto.user.SigninDto;
import com.example.sns.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signUpForm(@ModelAttribute("user") CreateUserDto createUserDto) {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signUp(@Validated @ModelAttribute("user") CreateUserDto createUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/signup";
        }

        //TODO : 회원가입 하기
        userService.createUser(createUserDto);

        return "redirect:/users/signin";
    }

    @GetMapping("/signin")
    public String signInForm(@ModelAttribute("user") SigninDto signinDto) {
        return "user/signin";
    }

    @PostMapping("/signin")
    public String signIn(@Validated @ModelAttribute("user") SigninDto signinDto, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "user/signin";
        }

        // 로그인 추가
        User signInUser = userService.signIn(signinDto);

        if (signInUser == null) {
            bindingResult.reject("fail", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "user/signin";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user", signInUser);

        return "redirect:/";
    }

    @GetMapping("/loguout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }
}
