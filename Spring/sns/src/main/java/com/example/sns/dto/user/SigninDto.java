package com.example.sns.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SigninDto {
    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
}
