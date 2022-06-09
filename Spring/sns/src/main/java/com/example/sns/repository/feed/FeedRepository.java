package com.example.sns.repository.feed;

import com.example.sns.domain.feed.Feed;
import com.example.sns.dto.feed.CreateFeedDto;

import java.util.List;
import java.util.Optional;

public interface FeedRepository {
    List<Feed> findAll();
    Optional<Feed> findById(Long id);
    Feed save(CreateFeedDto createFeedDto);
}
