package com.pardys.pardysback.image.repo;

import com.pardys.pardysback.image.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ImageDataRepo extends JpaRepository<ImageData, Long> {
    List<ImageData> findByName(String name);

    Optional<ImageData> findById(Long id);
//    Optional<ImageData> findAll
}