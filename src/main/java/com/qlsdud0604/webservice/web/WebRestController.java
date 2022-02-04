package com.qlsdud0604.webservice.web;

import com.qlsdud0604.webservice.domain.posts.PostsRepository;
import com.qlsdud0604.webservice.dto.PostsSaveRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDTO postsSaveRequestDTO) {
        postsRepository.save(postsSaveRequestDTO.toEntity());
    }
}
