package com.prasanna.jpa_one_to_many_blog.service;

import com.prasanna.jpa_one_to_many_blog.dto.PostDto;
import com.prasanna.jpa_one_to_many_blog.entity.Post;
import com.prasanna.jpa_one_to_many_blog.repository.PostRepository;
import com.prasanna.jpa_one_to_many_blog.repository.UserRepository;
import com.prasanna.jpa_one_to_many_blog.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PostDto createPost(PostDto postDto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found with id" + userId));
        Post post = modelMapper.map(postDto, Post.class);
        user.addPost(post);
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Post is not found with id:"+id));

        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByUserId(Long userId) {
        List<Post> list = postRepository.findByUserId(userId);
        return list.stream()
                .map(post->modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto updatePost(Long postId, PostDto postDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post is not found with id:"+postId));
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Post is not found with id:"+id));
        postRepository.delete(post);
    }
}
