package com.pardys.pardysback.image.service;




import com.pardys.pardysback.image.dto.ImageDataReadDTO;
import com.pardys.pardysback.image.dto.ImageDataCreateDTO;
import com.pardys.pardysback.image.entity.ImageData;
import com.pardys.pardysback.image.repo.ImageDataRepo;
import com.pardys.pardysback.image.util.ImageUtil;
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

    public String uploadImage(MultipartFile file) throws IOException {

        imageDataRepo.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());

        return new String("Image uploaded successfully: " +
                file.getOriginalFilename());

    }

//    @Transactional
    public ImageDataReadDTO getInfoByImageById(Long id) {
//        ImageData dbImage = imageDataRepo.findById(id).orElseThrow();


        return new ImageDataReadDTO().toDTO(imageDataRepo.findById(id).orElseThrow());
//        return dbImage.toDTO();
//
//                ImageData.builder()
//                .name(dbImage.getName())
//                .type(dbImage.getType())
//                .imageData(ImageUtil.decompressImage(dbImage.getImageData())).build();

    }

//    @Transactional
    public byte[] getImage(Long id) {
        System.out.println("in id get image by service 1");
        ImageData dbImage = imageDataRepo.findById(id).orElseThrow();
        System.out.println("in id get image by service 2");
        byte[] image = ImageUtil.decompressImage(dbImage.getImageData());
        System.out.println("in id get image by service 3");
        return image;

    }
}
