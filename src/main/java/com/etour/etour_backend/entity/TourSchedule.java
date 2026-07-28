package com.etour.etour_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tour_schedules")
public class TourSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate departureDate;

    private LocalDate arrivalDate;

    private Integer availableSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    @OneToMany(
            mappedBy = "tourSchedule",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PassengerPrice> passengerPrices = new ArrayList<>();

    @OneToMany(
            mappedBy = "tourSchedule",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Booking> bookings = new ArrayList<>();

    public TourSchedule() {
    }

    public TourSchedule(Long id,
                        LocalDate departureDate,
                        LocalDate arrivalDate,
                        Integer availableSeats,
                        Tour tour,
                        List<PassengerPrice> passengerPrices,
                        List<Booking> bookings) {
        this.id = id;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.availableSeats = availableSeats;
        this.tour = tour;
        this.passengerPrices = passengerPrices;
        this.bookings = bookings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
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

    public List<PassengerPrice> getPassengerPrices() {
        return passengerPrices;
    }

    public void setPassengerPrices(List<PassengerPrice> passengerPrices) {
        this.passengerPrices = passengerPrices;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}