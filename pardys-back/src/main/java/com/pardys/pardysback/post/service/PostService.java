package com.pardys.pardysback.post.service;

import com.pardys.pardysback.image.entity.ImageData;
import com.pardys.pardysback.image.repo.ImageDataRepo;
import com.pardys.pardysback.post.dto.PostCreateDTO;
import com.pardys.pardysback.post.dto.PostReadDTO;

import java.util.List;


import com.pardys.pardysback.post.dto.PostUpdateDTO;
import com.pardys.pardysback.post.entity.Post;
import com.pardys.pardysback.post.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;
    private final ImageDataRepo imageDataRepo;

    public List<PostReadDTO> readAll() {
        return postRepo.findAll()
                .stream()
                .map(PostReadDTO::new)
                .collect(Collectors.toList());
    }

    public void createPost(PostCreateDTO postCreateDTO) {
        ImageData image = imageDataRepo.findById(postCreateDTO.getImageId()).orElseThrow();
        postRepo.save(postCreateDTO.toEntity(image));
    }


    public void updatePost(Long id, PostUpdateDTO postUpdateDTO) {
        Post post = postRepo.findById(id).orElseThrow();
        post = postUpdateDTO.toDTO();
        postRepo.save(post);
    }

    public void deleteById(Long id) {
        postRepo.deleteById(id);
    }

    public PostReadDTO readById(Long id) {
        return postRepo.findById(id).get().toDTO();
    }

    public List<PostReadDTO> readByCategory(Integer category) {
        return postRepo.findByCategory(category)
                .stream()
                .map(PostReadDTO::new)
                .collect(Collectors.toList());
    }
}
