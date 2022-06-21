package com.example.sns.dto.feed;

import com.example.sns.domain.feed.FeedComment;
import com.example.sns.domain.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetFeedCommentFullInfoDto {
    private FeedComment feedComment;
    private User feedCommentAuthor;
}
