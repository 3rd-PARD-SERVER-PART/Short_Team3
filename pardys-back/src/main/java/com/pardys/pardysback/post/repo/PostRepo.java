package com.pardys.pardysback.post.repo;

import com.pardys.pardysback.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {

}
