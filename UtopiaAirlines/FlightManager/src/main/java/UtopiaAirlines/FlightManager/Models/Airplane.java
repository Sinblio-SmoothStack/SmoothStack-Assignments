package UtopiaAirlines.FlightManager.Models;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "type_id")
    private AirplaneType airplaneType;

    public Airplane() {}

    public Airplane(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Airplane) {
            Airplane toCompare = (Airplane) o;
            if (this.id == toCompare.id && this.airplaneType.equals(toCompare.airplaneType))
                return true;
        }
        return false;
    }
}