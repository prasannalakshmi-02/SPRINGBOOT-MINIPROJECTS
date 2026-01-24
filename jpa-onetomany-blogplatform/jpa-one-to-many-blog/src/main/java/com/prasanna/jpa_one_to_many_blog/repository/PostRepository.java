package com.prasanna.jpa_one_to_many_blog.repository;

import com.prasanna.jpa_one_to_many_blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
       List<Post> findByUserId(Long id);
}
