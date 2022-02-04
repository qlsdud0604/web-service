package com.qlsdud0604.webservice.domain;

import com.qlsdud0604.webservice.domain.posts.Posts;
import com.qlsdud0604.webservice.domain.posts.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_저장_조회_테스트() {
        // given
        postsRepository.save(Posts.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("테스트 글쓴이")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo("테스트 제목");
        Assertions.assertThat(posts.getContent()).isEqualTo("테스트 내용");
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.now();

        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 내용")
                .author("테스트 글쓴이")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        org.junit.jupiter.api.Assertions.assertTrue(posts.getCreatedDate().isAfter(now));
        org.junit.jupiter.api.Assertions.assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
