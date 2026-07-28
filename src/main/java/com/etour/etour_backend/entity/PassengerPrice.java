package com.etour.etour_backend.entity;

import com.etour.etour_backend.enums.PassengerType;
import jakarta.persistence.*;

@Entity
@Table(name = "passenger_prices")
public class PassengerPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PassengerType passengerType;

    @Column(nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_schedule_id", nullable = false)
    private TourSchedule tourSchedule;

    public PassengerPrice() {
    }

    public PassengerPrice(Long id,
                          PassengerType passengerType,
                          Double price,
                          TourSchedule tourSchedule) {
        this.id = id;
        this.passengerType = passengerType;
        this.price = price;
        this.tourSchedule = tourSchedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TourSchedule getTourSchedule() {
        return tourSchedule;
    }

    public void setTourSchedule(TourSchedule tourSchedule) {
        this.tourSchedule = tourSchedule;
    }
}