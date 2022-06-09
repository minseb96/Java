package com.example.sns.dto.feed;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateFeedCommentDto {
    private String content;
    private Long authorId;
    private Long feedId;
}
