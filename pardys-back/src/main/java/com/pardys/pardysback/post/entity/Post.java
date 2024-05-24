package com.pardys.pardysback.post.entity;


import com.pardys.pardysback.image.entity.ImageData;
import com.pardys.pardysback.post.dto.PostReadDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id; // 아이디 자동으로 증가함


    private String title; // 작품 명

    private Integer category; // 카테고리

    private String painter; // 작가명

    private String expLanation; // 1. 실패에 대해 자세하게 설명해주세요

    private String learned;     // 2. 실패를 겪으며 배운 점을 작성해주세요

    private String lacked;      // 3. 실패를 겪으며 깨달은 나의 부족한 부분을 작성해주세요

    private String longedFor;   // 4. 이 실패를 더 겪지 않으려면, 뭘 더 하면 좋을까요?

    @OneToOne
//    @JoinColumn(nullable = false ,name = "image")
    private ImageData imageData;


    public PostReadDTO toDTO(){
        return PostReadDTO.builder()
                .id(this.getId())
                .title(this.getTitle())
                .category(this.getCategory())
                .painter(this.getPainter())
                .expLanation(this.getExpLanation())
                .learned(this.getLearned())
                .lacked(this.getLacked())
                .longedFor(this.getLongedFor())
                .imageDataReadDTO(this.getImageData().toDTO())
                .build();
    }

}
