package com.pardys.pardysback.image.controller;

import com.pardys.pardysback.image.dto.ImageDataReadDTO;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import com.pardys.pardysback.image.service.ImageDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageDataController {

    @Autowired
    private ImageDataService imageDataService;

    @PostMapping("")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        Long response = imageDataService.uploadImage(file);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
//    @PostMapping
//    public Integer uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
//        String response = imageDataService.uploadImage(file);
//
//        return
//    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getImageInfoById(@PathVariable("id") Long id){
        ImageDataReadDTO image = imageDataService.getInfoByImageById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImageById(@PathVariable("id") Long id){
        byte[] image = imageDataService.getImage(id);

        System.out.println("in id get image by id mapping");

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }


}