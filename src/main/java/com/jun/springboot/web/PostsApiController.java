package com.jun.springboot.web;

import com.jun.springboot.service.posts.PostsService;
import com.jun.springboot.web.dto.PostsResponseDto;
import com.jun.springboot.web.dto.PostsSaveRequestDto;
import com.jun.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // post 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    
    // post 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    // post 조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}