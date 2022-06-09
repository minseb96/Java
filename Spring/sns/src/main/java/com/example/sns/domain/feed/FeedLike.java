package com.example.sns.domain.feed;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class FeedLike {
    private Long id;
    private Date createDateTime;
    private Boolean isLike;
    private Long userId;
    private Long feedId;
}
