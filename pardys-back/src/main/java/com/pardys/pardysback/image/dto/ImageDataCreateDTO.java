package com.pardys.pardysback.image.dto;

import com.pardys.pardysback.image.entity.ImageData;
import lombok.Getter;

@Getter
public class ImageDataCreateDTO {
    private String name;
    private String type;
    private byte [] imageData;



    public ImageData toEntity() {
        return ImageData.builder()
                .name(this.name)
                .type(this.type)
                .imageData(this.getImageData())
                .build();
    }
}