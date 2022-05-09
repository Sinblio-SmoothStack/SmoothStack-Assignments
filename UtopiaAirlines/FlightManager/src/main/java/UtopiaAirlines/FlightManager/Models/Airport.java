package UtopiaAirlines.FlightManager.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @Column(name = "iata_id", nullable = false, length = 3)
    private String id;

    @Column(name = "city", nullable = false, length = 45)
    private String city;

    public Airport() {}

    public Airport(String id, String city) {
        this.id = id;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Airport) {
            Airport toCompare = (Airport) o;
            if (this.id.equals(toCompare.id) &&  this.city.equals(toCompare.city))
                return true;
        }

        return false;
    }
}