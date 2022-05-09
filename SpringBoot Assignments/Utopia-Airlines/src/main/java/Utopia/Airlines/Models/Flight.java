package Utopia.Airlines.Models;

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
    private Integer reservedEconomySeats;

    @Column(name = "reserved_business_seats")
    private Integer reservedBusinessSeats;

    @Column(name = "reserved_first_seats")
    private Integer reservedFirstSeats;

    @Column(name = "seat_price_economy")
    private Float seatPriceEconomy;

    @Column(name = "seat_price_business")
    private Float seatPriceBusiness;

    @Column(name = "seat_price_first")
    private Float seatPriceFirst;

    public Flight() {}

    public Flight(Route route, Airplane airplane, LocalDateTime departureTime,
                  Integer reservedEconomySeats, Integer reservedBusinessSeats, Integer reservedFirstSeats,
                  Float seatPriceEconomy, Float seatPriceBusiness, Float seatPriceFirst) {
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

    public Integer getReservedEconomySeats() {
        return reservedEconomySeats;
    }

    public void setReservedEconomySeats(Integer reservedEconomySeats) {
        this.reservedEconomySeats = reservedEconomySeats;
    }

    public Integer getReservedBusinessSeats() {
        return reservedBusinessSeats;
    }

    public void setReservedBusinessSeats(Integer reservedBusinessSeats) {
        this.reservedBusinessSeats = reservedBusinessSeats;
    }

    public Integer getReservedFirstSeats() {
        return reservedFirstSeats;
    }

    public void setReservedFirstSeats(Integer reservedFirstSeats) {
        this.reservedFirstSeats = reservedFirstSeats;
    }

    public Float getSeatPriceEconomy() {
        return seatPriceEconomy;
    }

    public void setSeatPriceEconomy(Float seatPriceEconomy) {
        this.seatPriceEconomy = seatPriceEconomy;
    }

    public Float getSeatPriceBusiness() {
        return seatPriceBusiness;
    }

    public void setSeatPriceBusiness(Float seatPriceBusiness) {
        this.seatPriceBusiness = seatPriceBusiness;
    }

    public Float getSeatPriceFirst() {
        return seatPriceFirst;
    }

    public void setSeatPriceFirst(Float seatPriceFirst) {
        this.seatPriceFirst = seatPriceFirst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}