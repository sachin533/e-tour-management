package com.etour.etour_backend.repository;

import com.etour.etour_backend.entity.PassengerPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerPriceRepository extends JpaRepository<PassengerPrice, Long> {

    List<PassengerPrice> findByTourScheduleId(Long tourScheduleId);

}