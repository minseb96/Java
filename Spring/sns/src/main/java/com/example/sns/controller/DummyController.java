package com.example.sns.controller;

import com.example.sns.domain.feed.Feed;
import com.example.sns.domain.feed.FeedComment;
import com.example.sns.domain.user.User;
import com.example.sns.dto.feed.CreateFeedCommentDto;
import com.example.sns.dto.feed.CreateFeedDto;
import com.example.sns.dto.user.CreateUserDto;
import com.example.sns.service.feed.FeedCommentService;
import com.example.sns.service.feed.FeedService;
import com.example.sns.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dummy")
public class DummyController {
    private final FeedService feedService;
    private final FeedCommentService feedCommentService;
    private final UserService userService;

    public DummyController(FeedService feedService, FeedCommentService feedCommentService, UserService userService) {
        this.feedService = feedService;
        this.feedCommentService = feedCommentService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createDummyData(Model model){
        // Create dummy users
        List<User> users = createDummyUsers();

        // Create dummy feeds
        Long userId = users.get(0).getId();
        List<Feed> feeds = createDummyFeeds(userId);

        //Create dummy feedComments
        Long feedId = feeds.get(0).getId();
        List<FeedComment> feedComments = createDummyFeedComments(userId, feedId);

        return "dummy/complete.html";
    }

    private List<User> createDummyUsers(){
        ArrayList<User> users = new ArrayList<>();
        final int COUNT = 2;
        for (int i=0; i< COUNT; i++){
            CreateUserDto createUserDto = new CreateUserDto();

            createUserDto.setName("유저" + Integer.toString(i));
            createUserDto.setProfileImg("/images/resources/friend-avatar10.jpg");

            User user = userService.createUser(createUserDto);
            users.add(user);
        }

        return users;
    }

    private List<Feed> createDummyFeeds(Long authorId){
        ArrayList<Feed> feeds = new ArrayList<>();
        final int COUNT = 2;
        for (int i =0; i<COUNT; i++){
            CreateFeedDto createFeedDto = new CreateFeedDto();
            createFeedDto.setAuthorId(authorId);
            createFeedDto.setContent("피드 내용 테스트입니다 " + Integer.toString(i));
            createFeedDto.setImg("/images/resources/user-post.jpg");

            Feed feed = feedService.createFeed(createFeedDto);
            feeds.add(feed);
        }

        return feeds;
    }

    private List<FeedComment> createDummyFeedComments(Long authorId, Long feedId){
        ArrayList<FeedComment> feedComments = new ArrayList<>();
        final int COUNT = 2;
        for (int i =0; i<COUNT; i++){
            CreateFeedCommentDto createFeedCommentDto = new CreateFeedCommentDto();
            createFeedCommentDto.setFeedId(feedId);
            createFeedCommentDto.setAuthorId(authorId);
            createFeedCommentDto.setContent("댓글 내용입니다. " + Integer.toString(i));

            FeedComment feedComment = feedCommentService.createFeedComment(createFeedCommentDto);
            feedComments.add(feedComment);
        }

        return feedComments;
    }
}
