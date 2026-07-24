package com.etour.etour_backend.repository;

import com.etour.etour_backend.entity.PassengerPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerPriceRepository extends JpaRepository<PassengerPrice, Long> {

}