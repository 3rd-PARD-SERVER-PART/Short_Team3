package com.pardys.pardysback.image.dto;

import lombok.Getter;

@Getter
public class ImageDataCreateDTO {
    private String name;
    private String type;
    private byte [] imageData;
}
