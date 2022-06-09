package com.example.sns.service.feed;

import com.example.sns.domain.feed.FeedComment;
import com.example.sns.dto.feed.CreateFeedCommentDto;
import com.example.sns.repository.feed.FeedCommentRepository;

import java.util.List;

public class FeedCommentServiceImpl implements FeedCommentService{
    private final FeedCommentRepository feedCommentRepository;

    public FeedCommentServiceImpl(FeedCommentRepository feedCommentRepository){
        this.feedCommentRepository = feedCommentRepository;
    }

    @Override
    public FeedComment createFeedComment(CreateFeedCommentDto createFeedCommentDto) {
        return feedCommentRepository.save(createFeedCommentDto);
    }

    @Override
    public List<FeedComment> findCommentsByFeedId(Long id) {
        return feedCommentRepository.findCommentsByFeedId(id);
    }
}
