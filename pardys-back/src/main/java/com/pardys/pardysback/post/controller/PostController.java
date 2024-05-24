package com.pardys.pardysback.post.controller;

import com.pardys.pardysback.post.dto.PostCreateDTO;
import com.pardys.pardysback.post.dto.PostReadDTO;
import com.pardys.pardysback.post.dto.PostUpdateDTO;
import com.pardys.pardysback.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    //-------------------------------------------------
    // create
    @PostMapping("")
    public String createPost(PostCreateDTO postCreateDTO) {
        postService.createPost(postCreateDTO);
        return "완료";
    }

    //-------------------------------------------------
    // read
    @GetMapping("")
    public List<PostReadDTO> readAll() {
        return postService.readAll();
    }

    @GetMapping("/{id}")
    public PostReadDTO readPost(@PathVariable Long id) {
        return postService.readById(id);
    }


    //-------------------------------------------------
    //update
    @PatchMapping("/{id}")
    public String updateById(@PathVariable Long id, PostUpdateDTO postUpdateDTO) {
        postService.updatePost(id, postUpdateDTO);
        return "성공";
    }

    //-------------------------------------------------
    //delete
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        postService.deleteById(id);
        return "성공";

    }
}
