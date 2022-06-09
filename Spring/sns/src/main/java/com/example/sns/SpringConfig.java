package com.example.sns;

import com.example.sns.repository.feed.FeedCommentRepository;
import com.example.sns.repository.feed.FeedRepository;
import com.example.sns.repository.feed.MemoryFeedCommentRepository;
import com.example.sns.repository.feed.MemoryFeedRepository;
import com.example.sns.repository.user.MemoryUserRepository;
import com.example.sns.repository.user.UserRepository;
import com.example.sns.service.feed.FeedCommentService;
import com.example.sns.service.feed.FeedCommentServiceImpl;
import com.example.sns.service.feed.FeedService;
import com.example.sns.service.feed.MyFeedService;
import com.example.sns.service.user.UserService;
import com.example.sns.service.user.UserServiceImpl;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public FeedService feedService(){
        return new MyFeedService(feedRepository());
    }

    @Bean
    public FeedRepository feedRepository(){
        return new MemoryFeedRepository();
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl(userRepository());
    }
    @Bean
    public UserRepository userRepository(){ return new MemoryUserRepository(); }

    @Bean
    public FeedCommentService feedCommentService(){
        return new FeedCommentServiceImpl(feedCommentRepository());
    }

    @Bean
    public FeedCommentRepository feedCommentRepository() {
        return new MemoryFeedCommentRepository();
    }
}
