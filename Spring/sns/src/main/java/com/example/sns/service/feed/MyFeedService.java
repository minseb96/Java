package com.example.sns.service.feed;

import com.example.sns.domain.feed.Feed;
import com.example.sns.dto.feed.CreateFeedDto;
import com.example.sns.repository.feed.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public class MyFeedService implements FeedService{
    private FeedRepository feedRepository;

    @Autowired
    public MyFeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public List<Feed> findFeeds() {
        List<Feed> feeds = feedRepository.findAll();
        return feeds;
    }

    @Override
    public Optional<Feed> findFeedById(Long id) {
        return Optional.empty();
    }
    @Override
    public Feed createFeed(CreateFeedDto createFeedDto) {
        Feed feed = feedRepository.save(createFeedDto);
        return feed;
    }

}
