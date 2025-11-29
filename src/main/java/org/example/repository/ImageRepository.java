package org.example.repository;

import org.example.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("SELECT i.url FROM Image i WHERE i.id = :id")
    String findImageUrlById(Integer id);
}

