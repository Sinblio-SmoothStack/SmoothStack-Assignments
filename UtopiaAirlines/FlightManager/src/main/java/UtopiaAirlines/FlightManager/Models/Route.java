package UtopiaAirlines.FlightManager.Models;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Airport originAirport;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Airport destinationAirport;

    public Route() {}

    public Route(Airport originAirport, Airport destinationAirport) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(Airport originAirport) {
        this.originAirport = originAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Route) {
            Route toCompare = (Route) o;
            if (this.id == toCompare.id
                    && this.originAirport.equals(toCompare.originAirport)
                    && this.destinationAirport.equals(toCompare.destinationAirport))
                return true;
        }
        return false;
    }
}