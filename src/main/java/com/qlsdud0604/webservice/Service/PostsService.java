package com.qlsdud0604.webservice.Service;

import com.qlsdud0604.webservice.domain.posts.PostsRepository;
import com.qlsdud0604.webservice.dto.PostsMainResponseDTO;
import com.qlsdud0604.webservice.dto.PostsSaveRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDTO postsSaveRequestDTO) {
        return postsRepository.save(postsSaveRequestDTO.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDTO> findAllDesc() {
        return postsRepository.findAllDesc().map(posts -> new PostsMainResponseDTO(posts)).collect(Collectors.toList());
    }
}
