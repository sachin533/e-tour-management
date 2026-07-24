package com.etour.etour_backend.repository;

import com.etour.etour_backend.entity.TourSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourScheduleRepository extends JpaRepository<TourSchedule, Long> {

}