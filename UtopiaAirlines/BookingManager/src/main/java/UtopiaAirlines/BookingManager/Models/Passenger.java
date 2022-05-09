package UtopiaAirlines.BookingManager.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @Column(name = "booking_id")
    private Long bookingId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    public Passenger() {}

    public Passenger(Booking booking, String givenName, String familyName, LocalDate dob, String gender, String address) {
        this.bookingId = booking.getId();
        this.booking = booking;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Passenger) {
            Passenger toCompare = (Passenger) o;
            if (this.bookingId.equals(toCompare.bookingId) && this.booking.equals(toCompare.booking)
                    && this.givenName.equals(toCompare.givenName) && this.familyName.equals(toCompare.familyName)
                    && this.dob.equals(toCompare.dob) && this.gender.equals(toCompare.gender)
                    && this.address.equals(toCompare.address))
                return true;
        }
        return false;
    }
}