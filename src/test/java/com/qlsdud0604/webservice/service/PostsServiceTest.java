package com.qlsdud0604.webservice.service;

import com.qlsdud0604.webservice.Service.PostsService;
import com.qlsdud0604.webservice.domain.posts.Posts;
import com.qlsdud0604.webservice.domain.posts.PostsRepository;
import com.qlsdud0604.webservice.dto.PostsSaveRequestDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void DTO데이터를_posts테이블에_저장() {
        // given
        PostsSaveRequestDTO postsSaveRequestDTO = PostsSaveRequestDTO.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("테스트 글쓴이")
                .build();

        // when
        postsService.save(postsSaveRequestDTO);

        // then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getTitle()).isEqualTo("테스트 제목");
        assertThat(posts.getContent()).isEqualTo("테스트 내용");
        assertThat(posts.getAuthor()).isEqualTo("테스트 글쓴이");
    }
}
