package com.pardys.pardysback.image.dto;

import com.pardys.pardysback.image.entity.ImageData;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDataReadDTO {
    private Long id;

    private String name;
    private String type;
    private byte[] imageData;

    public ImageDataReadDTO toDTO(ImageData imageData) {
        return ImageDataReadDTO.builder()
                .id(imageData.getId())
                .name(imageData.getName())
                .type(imageData.getType())
                .imageData(imageData.getImageData())
                .build();
    }


}
