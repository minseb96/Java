package com.example.sns.domain.feed;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Feed {
    private Long id;
    private Date createDateTime;
    private String img;
    private String content;
    private int viewCount;
    private int commentCount;
    private int likeCount;
    private int dislikeCount;
    private Long authorId;
}
