package UtopiaAirlines.FlightManager.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "reserved_economy_seats")
    private int reservedEconomySeats;

    @Column(name = "reserved_business_seats")
    private int reservedBusinessSeats;

    @Column(name = "reserved_first_seats")
    private int reservedFirstSeats;

    @Column(name = "seat_price_economy")
    private float seatPriceEconomy;

    @Column(name = "seat_price_business")
    private float seatPriceBusiness;

    @Column(name = "seat_price_first")
    private float seatPriceFirst;

    public Flight() {}

    public Flight(Route route, Airplane airplane, LocalDateTime departureTime,
                  int reservedEconomySeats, int reservedBusinessSeats, int reservedFirstSeats,
                  float seatPriceEconomy, float seatPriceBusiness, float seatPriceFirst) {
        this.route = route;
        this.airplane = airplane;
        this.departureTime = departureTime;
        this.reservedEconomySeats = reservedEconomySeats;
        this.reservedBusinessSeats = reservedBusinessSeats;
        this.reservedFirstSeats = reservedFirstSeats;
        this.seatPriceEconomy = seatPriceEconomy;
        this.seatPriceBusiness = seatPriceBusiness;
        this.seatPriceFirst = seatPriceFirst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getReservedEconomySeats() {
        return reservedEconomySeats;
    }

    public void setReservedEconomySeats(int reservedEconomySeats) {
        this.reservedEconomySeats = reservedEconomySeats;
    }

    public int getReservedBusinessSeats() {
        return reservedBusinessSeats;
    }

    public void setReservedBusinessSeats(int reservedBusinessSeats) {
        this.reservedBusinessSeats = reservedBusinessSeats;
    }

    public int getReservedFirstSeats() {
        return reservedFirstSeats;
    }

    public void setReservedFirstSeats(int reservedFirstSeats) {
        this.reservedFirstSeats = reservedFirstSeats;
    }

    public float getSeatPriceEconomy() {
        return seatPriceEconomy;
    }

    public void setSeatPriceEconomy(float seatPriceEconomy) {
        this.seatPriceEconomy = seatPriceEconomy;
    }

    public float getSeatPriceBusiness() {
        return seatPriceBusiness;
    }

    public void setSeatPriceBusiness(float seatPriceBusiness) {
        this.seatPriceBusiness = seatPriceBusiness;
    }

    public float getSeatPriceFirst() {
        return seatPriceFirst;
    }

    public void setSeatPriceFirst(float seatPriceFirst) {
        this.seatPriceFirst = seatPriceFirst;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Flight) {
            Flight toCompare = (Flight) o;
            if (this.id == toCompare.id
                    && this.airplane.equals(toCompare.airplane)
                    && this.route.equals(toCompare.route)
                    && this.departureTime.equals(toCompare.departureTime)
                    && this.reservedEconomySeats == toCompare.reservedEconomySeats
                    && this.reservedBusinessSeats == toCompare.reservedBusinessSeats
                    && this.reservedFirstSeats == toCompare.reservedFirstSeats
                    && this.seatPriceEconomy == toCompare.seatPriceEconomy
                    && this.seatPriceBusiness == toCompare.seatPriceBusiness
                    && this.seatPriceFirst == toCompare.seatPriceFirst)
                return true;
        }
        return false;
    }
}