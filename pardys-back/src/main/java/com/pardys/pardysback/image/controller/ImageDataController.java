package com.pardys.pardysback.image.controller;


import com.pardys.pardysback.image.dto.ImageDataReadDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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




    @Operation(
            summary = "사진 등록",
            description = "DB에 사진을 등록하고 저장된 사진의 ID 값을 리턴합니다",
            parameters = {
                    @Parameter(name = "image", description = "이미지 파일[MultipartFile]", required = true)
            }
    )
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

//    @GetMapping("/info/{id}")
//    public ResponseEntity<?> getImageInfoById(@PathVariable("id") Long id){
//        ImageDataReadDTO image = imageDataService.getInfoByImageById(id);
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(image);
//    }



    @Operation(
            summary = "사진 받아오기",
            description = "DB에서 ID값으로 사진을 가져옵니다",
            parameters = {
                    @Parameter(name = "id", description = "사진의 ID 값", required = true)
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getImageById(@PathVariable("id") Long id){
        byte[] image = imageDataService.getImage(id);

        System.out.println("in id get image by id mapping");

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }


}