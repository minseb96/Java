package com.example.sns.repository.feed;

import com.example.sns.domain.feed.Feed;
import com.example.sns.dto.feed.CreateFeedDto;

import java.util.*;

public class MemoryFeedRepository implements FeedRepository{
    private static Map<Long, Feed> db = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public List<Feed> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public Optional<Feed> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public Feed save(CreateFeedDto createFeedDto) {
        Feed feed = new Feed();
        feed.setId(++sequence);
        feed.setCreateDateTime(new Date());
        feed.setImg(createFeedDto.getImg());
        feed.setContent(createFeedDto.getContent());
        feed.setViewCount(0);
        feed.setCommentCount(0);
        feed.setLikeCount(0);
        feed.setDislikeCount(0);
        feed.setAuthorId(createFeedDto.getAuthorId());

        db.put(feed.getId(), feed);
        return feed;
    }
}
