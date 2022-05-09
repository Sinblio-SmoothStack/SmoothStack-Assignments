package UtopiaAirlines.BookingManager.Models;

import javax.persistence.*;

@Entity
@Table(name = "booking_guest")
public class BookingGuest {
    @Id
    @Column(name = "booking_id")
    private Long bookingId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    public BookingGuest() {}

    public BookingGuest(Booking booking, String contactEmail, String contactPhone) {
        this.bookingId = booking.getId();
        this.booking = booking;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BookingGuest) {
            BookingGuest toCompare = (BookingGuest) o;
            if (this.bookingId.equals(toCompare.bookingId) && this.booking.equals(toCompare.booking)
                    && this.contactEmail.equals(this.contactEmail) && this.contactPhone.equals(toCompare.contactPhone))
                return true;
        }
        return false;
    }
}