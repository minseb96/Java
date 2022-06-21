package com.example.sns.service.feed;

import com.example.sns.domain.feed.Feed;
import com.example.sns.dto.feed.CreateFeedDto;

import java.util.List;
import java.util.Optional;

public interface FeedService {
    List<Feed> findFeeds();
    Optional<Feed> findFeedById(Long id);
    Feed createFeed(CreateFeedDto createFeedDto);
}
