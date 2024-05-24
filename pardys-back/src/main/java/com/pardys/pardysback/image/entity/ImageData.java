package com.pardys.pardysback.image.entity;

import com.pardys.pardysback.image.dto.ImageDataCreateDTO;
import com.pardys.pardysback.image.dto.ImageDataReadDTO;
import jakarta.persistence.*;
import lombok.*;
//import org.example.pard.member.dto.MemberCreateDTO;



@Entity
@Table(name = "imageData")
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;


    @Lob
    @Column(name = "imagedata", length = 20000000)
    private byte[] imageData;

    public ImageData toEntity(ImageDataCreateDTO dto){
        return ImageData.builder()
                .name(dto.getName())
                .type(dto.getType())
                .imageData(dto.getImageData())
                .build();
//        return ImageData.builder()
//                .name(dto.getName())
//                .type(dto.getType())
//                .imageData(dto.getImageData())
//                .build();
    }


//    public ImageDataReadDTO toDTO(){
//        return ImageDataReadDTO.builder()
//                .name(this.getName())
//                .type(this.getType())
//                .imageData(this.getImageData())
//                .build();
//    }
}