package com.pardys.pardysback.image.service;




import com.pardys.pardysback.image.dto.ImageDataReadDTO;
import com.pardys.pardysback.image.dto.ImageDataCreateDTO;
import com.pardys.pardysback.image.entity.ImageData;
import com.pardys.pardysback.image.repo.ImageDataRepo;
import com.pardys.pardysback.image.util.ImageUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageDataService {

    @Autowired
    private ImageDataRepo imageDataRepo;

//    public String uploadImage(MultipartFile file) throws IOException {
//
//        imageDataRepo.save(ImageData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtil.compressImage(file.getBytes())).build());
//
//        return new String("Image uploaded successfully: " +
//                file.getOriginalFilename());
//
//    }

//    @Operation(
//            summary = "사진 업로드",
//            description = "사진을 업로드 하고, 사진의 아이디를 리턴합니다"
//    )
    public Long uploadImage(MultipartFile file) throws IOException {
        ImageData savedImage = imageDataRepo.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .build());

        return savedImage.getId();
    }

//    public Integer uploadImage(MultipartFile file) throws IOException {
//
//        imageDataRepo.save(ImageData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtil.compressImage(file.getBytes())).build());
//
//        return new Integer(1);
//
//    }

//    @Transactional


//    @Operation(
//            summary = "사진 업로드",
//            description = "사진을 업로드 하고, 사진의 아이디를 리턴합니다"
//    )
//    public ImageDataReadDTO getInfoByImageById(Long id) {
////        ImageData dbImage = imageDataRepo.findById(id).orElseThrow();
//
//
//        return new ImageDataReadDTO().toDTO(imageDataRepo.findById(id).orElseThrow());
////        return dbImage.toDTO();
////
////                ImageData.builder()
////                .name(dbImage.getName())
////                .type(dbImage.getType())
////                .imageData(ImageUtil.decompressImage(dbImage.getImageData())).build();
//
//    }

//    @Transactional


//    @Operation(
//            summary = "사진 받아오기",
//            description = "사진 데이터를 받아옵니다",
//            parameters = {
//            @Parameter(name = "id", description = "사진의 id 값", required = true)
//    }
//    )
    public byte[] getImage(Long id) {

        System.out.println("in id get image by service 1");
        ImageData dbImage = imageDataRepo.findById(id).orElseThrow();
        System.out.println("in id get image by service 2");
        byte[] image = ImageUtil.decompressImage(dbImage.getImageData());
        System.out.println("in id get image by service 3");
        return image;

    }
}
