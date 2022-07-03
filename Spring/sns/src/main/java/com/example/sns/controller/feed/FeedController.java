package com.example.sns.controller.feed;

import com.example.sns.domain.feed.Feed;
import com.example.sns.domain.user.User;
import com.example.sns.dto.feed.CreateFeedDto;
import com.example.sns.dto.feed.GetFeedFullInfoDto;
import com.example.sns.service.feed.FeedFullService;
import com.example.sns.service.feed.FeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class FeedController {
    private final FeedService feedService;
    private final FeedFullService feedFullService;

    @PostMapping("/create/feed")
    public String createFeed(@SessionAttribute(name="user")User user, @RequestParam String content){
        Long myUserId = user.getId(); // TODO: get this value from session
        String imgUrl = "/image/resources/user-post.jpg"; // TODO: modify this to image upload

        CreateFeedDto createFeedDto = new CreateFeedDto();
        createFeedDto.setContent(content);
        createFeedDto.setAuthorId(myUserId);
        createFeedDto.setImg(imgUrl);

        feedService.createFeed(createFeedDto);

        return "redirect:/";
    }

    @GetMapping
    public String getFeedList(@SessionAttribute(name = "user", required = false) User user, Model model) {
        List<GetFeedFullInfoDto> feeds = feedFullService.findFeedsFullInfo();
        model.addAttribute("feeds", feeds);
        model.addAttribute("feedForm", new CreateFeedDto());
        model.addAttribute("user", user);
        return "feed/newsfeed";
    }

    //TODO: API로 Feed를 생성하는 PostMapping 만들기
    @ResponseBody
    @PostMapping("/api/create")
    public Feed createNewFeed(@RequestBody CreateFeedDto createFeedDto){
        Feed feed = feedService.createFeed(createFeedDto);
        return feed;
    }
}
