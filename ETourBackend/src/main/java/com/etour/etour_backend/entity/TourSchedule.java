package com.etour.etour_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tour_schedules")
public class TourSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate departureDate;

    private Integer availableSeats;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    public TourSchedule() {
    }

    public TourSchedule(Long id, LocalDate departureDate, Integer availableSeats, Tour tour) {
        this.id = id;
        this.departureDate = departureDate;
        this.availableSeats = availableSeats;
        this.tour = tour;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}