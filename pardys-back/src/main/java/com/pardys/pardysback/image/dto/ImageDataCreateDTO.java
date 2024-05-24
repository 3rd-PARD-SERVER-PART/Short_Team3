package com.pardys.pardysback.image.dto;

import com.pardys.pardysback.image.entity.ImageData;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;

@Getter
public class ImageDataCreateDTO {
    private String name;
    private String type;
    private byte [] imageData;



    @Operation(
            summary = "ImageDataCreateDTO -> ImageData",
            description = "readDTO를 entity로 변환합니다"
    )
    public ImageData toEntity() {
        return ImageData.builder()
                .name(this.name)
                .type(this.type)
                .imageData(this.getImageData())
                .build();
    }
}