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

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private TourSchedule schedule;

    public PassengerPrice() {
    }

    public Long getId() {
        return id;
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

    public TourSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(TourSchedule schedule) {
        this.schedule = schedule;
    }
}