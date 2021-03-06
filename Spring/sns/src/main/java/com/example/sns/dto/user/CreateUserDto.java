package com.example.sns.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CreateUserDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String profileImg;
    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
}
