package com.example.sns.service.feed;

import com.example.sns.domain.feed.FeedComment;
import com.example.sns.dto.feed.CreateFeedCommentDto;

import java.util.List;

public interface FeedCommentService {
    FeedComment createFeedComment(CreateFeedCommentDto createFeedCommentDto);
    List<FeedComment> findCommentsByFeedId(Long id);
}
