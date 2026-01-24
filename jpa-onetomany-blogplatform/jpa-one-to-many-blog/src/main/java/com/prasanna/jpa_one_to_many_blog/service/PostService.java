package com.prasanna.jpa_one_to_many_blog.service;

import com.prasanna.jpa_one_to_many_blog.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Long userId);


    PostDto getPostById(Long id);


    List<PostDto> getPostsByUserId(Long userId);


    PostDto updatePost(Long postId, PostDto postDto);


    void deletePost(Long id);
}
