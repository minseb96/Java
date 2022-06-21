package com.example.sns.dto.feed;

import com.example.sns.domain.feed.Feed;
import com.example.sns.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class GetFeedFullInfoDto {
    private Feed feed;
    private User feedAuthor;
    private List<GetFeedCommentFullInfoDto> feedComments;

    public GetFeedFullInfoDto() {
        feed = new Feed();
        feedAuthor = new User();
        feedComments = new ArrayList<GetFeedCommentFullInfoDto>();
    }

    public GetFeedCommentFullInfoDto addFeedComment(GetFeedCommentFullInfoDto feedComment) {
        feedComments.add(feedComment);
        return feedComment;
    }
}
