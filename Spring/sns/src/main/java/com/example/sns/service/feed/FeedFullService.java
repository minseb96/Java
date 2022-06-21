package com.example.sns.service.feed;

import com.example.sns.dto.feed.GetFeedFullInfoDto;

import java.util.List;

public interface FeedFullService {
    List<GetFeedFullInfoDto> findFeedsFullInfo();

}
