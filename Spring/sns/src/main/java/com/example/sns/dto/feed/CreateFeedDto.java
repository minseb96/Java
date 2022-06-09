package com.example.sns.dto.feed;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class CreateFeedDto {
    private Long authorId;
    private String img;
    private String content;
}
