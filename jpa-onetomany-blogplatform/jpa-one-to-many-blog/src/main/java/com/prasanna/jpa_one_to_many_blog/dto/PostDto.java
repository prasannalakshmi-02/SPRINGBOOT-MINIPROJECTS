package com.prasanna.jpa_one_to_many_blog.dto;

import lombok.Data;

@Data
public class PostDto {

    private Long id;
    private String title;
    private String content;
}
