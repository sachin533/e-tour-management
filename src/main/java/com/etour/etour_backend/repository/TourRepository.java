package com.etour.etour_backend.repository;

import com.etour.etour_backend.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {

    List<Tour> findByCategoryId(Long categoryId);

    List<Tour> findByDestinationContainingIgnoreCase(String destination);

    List<Tour> findByTourNameContainingIgnoreCase(String tourName);

}