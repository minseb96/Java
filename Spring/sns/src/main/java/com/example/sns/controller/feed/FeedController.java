package com.example.sns.controller.feed;

import com.example.sns.domain.feed.Feed;
import com.example.sns.dto.feed.CreateFeedDto;
import com.example.sns.service.feed.FeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feed")
@Controller
@Slf4j
public class FeedController {
    private final FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping
    public String getFeedList(Model model) {
        List<Feed> feeds = feedService.findFeed();
        model.addAttribute("feeds", feeds);

        for (Feed feed : feeds) {
            log.debug("feed's img : {}", feed.getImg());
            log.debug("feed's content : {}", feed.getContent());
            log.debug("--------------------------------------------");
        }

//        TODO: 서비스를 통해 Feed 배열을 가져오기
//         Log로 확인해보기
        return "feed/newsfeed";
    }

    //TODO: API로 Feed를 생성하는 PostMapping 만들기
    @ResponseBody
    @PostMapping
    public Feed createNewFeed(@RequestBody CreateFeedDto createFeedDto){
        Feed feed = feedService.createFeed(createFeedDto);
        return feed;
    }
}
