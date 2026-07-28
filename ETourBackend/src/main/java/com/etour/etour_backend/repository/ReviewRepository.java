package com.etour.etour_backend.repository;

import com.etour.etour_backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByTourId(Long tourId);

    List<Review> findByUserId(Long userId);

}