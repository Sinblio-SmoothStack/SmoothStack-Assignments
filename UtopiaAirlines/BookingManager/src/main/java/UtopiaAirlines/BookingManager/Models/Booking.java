package UtopiaAirlines.BookingManager.Models;

import javax.persistence.*;
import java.awt.print.Book;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="confirmation_code")
    private String confirmationCode;

    @Column(name = "seat_class")
    private String seatClass;

    public Booking() {}

    public Booking(boolean isActive, String confirmationCode, String seatClass) {
        this.isActive = isActive;
        this.confirmationCode = confirmationCode;
        this.seatClass = seatClass;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Booking) {
            Booking toCompare = (Booking) o;
            if (this.id.equals(toCompare.id) && this.isActive.equals(toCompare.confirmationCode)
                    && this.confirmationCode.equals(toCompare.confirmationCode)
                    && this.seatClass.equals(toCompare.seatClass))
                return true;
        }
        return false;
    }
}