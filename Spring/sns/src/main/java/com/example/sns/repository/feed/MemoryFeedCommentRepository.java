package com.example.sns.repository.feed;

import com.example.sns.domain.feed.Feed;
import com.example.sns.domain.feed.FeedComment;
import com.example.sns.dto.feed.CreateFeedCommentDto;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryFeedCommentRepository implements FeedCommentRepository{
    private static Map<Long, FeedComment> db = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public FeedComment save(CreateFeedCommentDto createFeedCommentDto) {
        FeedComment feedComment = new FeedComment();
        feedComment.setId(++sequence);
        feedComment.setFeedId(createFeedCommentDto.getFeedId());
        feedComment.setContent(createFeedCommentDto.getContent());
        feedComment.setAuthorId(createFeedCommentDto.getAuthorId());
        feedComment.setCreateDateTime(new Date());

        db.put(feedComment.getId(), feedComment);

        return feedComment;
    }

    @Override
    public List<FeedComment> findCommentsByFeedId(Long id) {
        return new ArrayList<>(
                db.values()
                .stream()
                .filter(comment -> comment.getFeedId().equals(id))
                .collect(Collectors.toList())
        );
    }
}
