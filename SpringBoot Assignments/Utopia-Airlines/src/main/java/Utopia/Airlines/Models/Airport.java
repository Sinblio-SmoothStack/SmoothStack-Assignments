package Utopia.Airlines.Models;

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
        if (o instanceof Airport)
            if (((Airport) o).getCity().equals(this.city) && ((Airport) o).getId().equals(this.id))
                return true;

        return false;
    }
}