package com.pardys.pardysback.image.repo;

import com.pardys.pardysback.image.entity.ImageData;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface ImageDataRepo extends JpaRepository<ImageData, Long> {
    List<ImageData> findByName(String name);
}