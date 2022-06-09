package com.example.sns.repository.feed;

import com.example.sns.domain.feed.FeedComment;
import com.example.sns.dto.feed.CreateFeedCommentDto;

import java.util.List;

public interface FeedCommentRepository {
    FeedComment save(CreateFeedCommentDto createFeedCommentDto);
    List<FeedComment> findCommentsByFeedId(Long id);
}
