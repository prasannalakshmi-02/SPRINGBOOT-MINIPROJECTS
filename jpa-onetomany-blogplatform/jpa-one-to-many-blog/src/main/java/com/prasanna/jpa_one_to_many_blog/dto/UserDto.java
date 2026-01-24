package com.prasanna.jpa_one_to_many_blog.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private List<PostDto> posts;
}
