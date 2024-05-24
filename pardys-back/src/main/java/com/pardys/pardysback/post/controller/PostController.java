package com.pardys.pardysback.post.controller;

import com.pardys.pardysback.post.dto.PostCreateDTO;
import com.pardys.pardysback.post.dto.PostReadDTO;
import com.pardys.pardysback.post.dto.PostUpdateDTO;
import com.pardys.pardysback.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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


    @Operation(
            summary = "New Post 생성",
            description = "새로운 Post를 생성합니다",
            parameters = {
                    @Parameter(name = "PostCreateDTO", description = "Post의 Create DTO", required = true)
            }
    )
    @PostMapping("")
    public String createPost(@RequestBody PostCreateDTO postCreateDTO) {
        postService.createPost(postCreateDTO);
        return "done";
    }

    //-------------------------------------------------
    // read

    @Operation(
            summary = "모든 Post 가져오기",
            description = "모든 Post데이터를 List로 가져옵니다"
    )
    @GetMapping("")
    public List<PostReadDTO> readAll() {
        return postService.readAll();
    }

    @Operation(
            summary = "카테고리의 Post 가져오기",
            description = "해당 카테고리의 모든 Post데이터를 List로 가져옵니다. <br />" +
                    "0 : 여행 <br />1 : 요리 <br />2 : 헤어 <br />3 : 패션 <br />4 : 맛집",
            parameters = {
                    @Parameter(name = "category", description = "카테고리 번호", required = true)
            }
    )
    @GetMapping("category/{category}")
    public List<PostReadDTO> readAll(@PathVariable Integer category) {
        return postService.readByCategory(category);
    }


    @Operation(
            summary = "해당 id의 Post 가져오기",
            description = "해당 id의 Post데이터를 가져옵니다",
            parameters = {
                    @Parameter(name = "category", description = "카테고리 번호", required = true)
            }
    )
    @GetMapping("/{id}")
    public PostReadDTO readPost(@PathVariable Long id) {
        return postService.readById(id);
    }


    //-------------------------------------------------
    //update

    @Operation(
            summary = "Post 수정",
            description = "해당 ID의 Post데이터를 수정합니다.",
            parameters = {
                    @Parameter(name = "id", description = "post의 id값", required = true)
            }
    )
    @PatchMapping("/{id}")
    public String updateById(@PathVariable Long id, PostUpdateDTO postUpdateDTO) {
        postService.updatePost(id, postUpdateDTO);
        return "성공";
    }

    //-------------------------------------------------
    //delete

    @Operation(
            summary = "Post 삭제",
            description = "해당 Post데이터를 삭제합니다. <br />",
            parameters = {
                    @Parameter(name = "id", description = "post의 id값", required = true)
            }
    )
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        postService.deleteById(id);
        return "성공";

    }
}
