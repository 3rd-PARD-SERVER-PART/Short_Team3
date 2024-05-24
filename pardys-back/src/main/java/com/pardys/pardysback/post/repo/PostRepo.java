package com.pardys.pardysback.post.repo;

import com.pardys.pardysback.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByCategory(Integer category); // 파트로 찾기
}
