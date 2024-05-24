package com.pardys.pardysback.image.dto;

import com.pardys.pardysback.image.entity.ImageData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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


//    @Operation(
//            summary = "ImageData -> ImageDataReadDTO",
//            description = "entity를 readDTO로 변환합니다",
//            parameters = {
//                    @Parameter(name = "imageData", description = "사진의 entity", required = true)
//            }
//    )

    public ImageDataReadDTO toDTO(ImageData imageData) {
        return ImageDataReadDTO.builder()
                .id(imageData.getId())
                .name(imageData.getName())
                .type(imageData.getType())
                .imageData(imageData.getImageData())
                .build();
    }

//
//    @Operation(
//            summary = "ImageDataReadDTO -> ImageData",
//            description = "ImageDataReadDTO를 ImageData 변환합니다"
//    )
    public ImageData toEntity() {
        return ImageData.builder()
                .name(this.getName())
                .type(this.getType())
                .imageData(this.getImageData())
                .build();
    }
}
