package com.example.sns.service.feed;

import com.example.sns.domain.feed.Feed;
import com.example.sns.domain.feed.FeedComment;
import com.example.sns.domain.user.User;
import com.example.sns.dto.feed.GetFeedCommentFullInfoDto;
import com.example.sns.dto.feed.GetFeedFullInfoDto;
import com.example.sns.service.user.UserService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FeedFullServiceImpl implements FeedFullService{
    private final FeedService feedService;
    private final FeedCommentService feedCommentService;
    private final UserService userService;

    @Override
    public List<GetFeedFullInfoDto> findFeedsFullInfo() {
        List<GetFeedFullInfoDto> fullFeeds = new ArrayList<>();

        List<Feed> feeds = feedService.findFeeds();

        for (Feed feed : feeds) {
            //Get Author
            Long userId = feed.getAuthorId();
            User author = userService.findUserById(userId).get();

            //Get comments
            Long feedId = feed.getId();
            List<FeedComment> feedComments = feedCommentService.findCommentsByFeedId(feedId);
            List<GetFeedCommentFullInfoDto> getFeedCommentFullInfoDtos = new ArrayList<>();
            for (FeedComment feedComment : feedComments) {
                GetFeedCommentFullInfoDto getFeedCommentFullInfoDto = new GetFeedCommentFullInfoDto();
                getFeedCommentFullInfoDto.setFeedComment(feedComment);
                getFeedCommentFullInfoDto.setFeedCommentAuthor(
                        userService.findUserById(
                                feedComment.getAuthorId()
                        ).get()
                );
                getFeedCommentFullInfoDtos.add(getFeedCommentFullInfoDto);
            }
            GetFeedFullInfoDto getFeedFullInfoDto = new GetFeedFullInfoDto();

            getFeedFullInfoDto.setFeed(feed);
            getFeedFullInfoDto.setFeedAuthor(author);
            getFeedFullInfoDto.setFeedComments(getFeedCommentFullInfoDtos);

            fullFeeds.add(getFeedFullInfoDto);
        }

        return fullFeeds;
    }
}
