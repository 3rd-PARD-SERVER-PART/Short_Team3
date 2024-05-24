package com.pardys.pardysback.post.dto;

import com.pardys.pardysback.image.dto.ImageDataReadDTO;
import com.pardys.pardysback.image.entity.ImageData;
import com.pardys.pardysback.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostReadDTO {
    private Long id;
    private String title;
    private Integer category;
    private String painter;

    private String expLanation; // 1. 실패에 대해 자세하게 설명해주세요

    private String learned;     // 2. 실패를 겪으며 배운 점을 작성해주세요

    private String lacked;      // 3. 실패를 겪으며 깨달은 나의 부족한 부분을 작성해주세요

    private String longedFor;   // 4. 이 실패를 더 겪지 않으려면, 뭘 더 하면 좋을까요?

    private ImageDataReadDTO imageDataReadDTO;


    public PostReadDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.category = post.getCategory();
        this.painter = post.getPainter();
        this.expLanation = post.getExpLanation();
        this.learned = post.getLearned();
        this.lacked = post.getLacked();
        this.longedFor = post.getLongedFor();
        this.imageDataReadDTO = post.getImageData().toDTO();
    }

    public Post toEntity() {
        return Post.builder()
                .id(this.getId())
                .title(this.getTitle())
                .category(this.getCategory())
                .painter(this.getPainter())
                .expLanation(this.getExpLanation())
                .learned(this.getLearned())
                .lacked(this.getLacked())
                .longedFor(this.getLongedFor())
                .imageData(this.getImageDataReadDTO().toEntity())
                .build();
    }
}
