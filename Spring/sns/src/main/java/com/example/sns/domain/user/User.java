package com.example.sns.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private Long id;
    private String name;
    private String profileImg;
    private String loginId;
    private String password;
}
