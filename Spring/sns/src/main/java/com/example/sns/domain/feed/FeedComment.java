package com.example.sns.domain.feed;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class FeedComment {
    private Long id;
    private Date createDateTime;
    private String content;
    private Long authorId;
    private Long feedId;
}
