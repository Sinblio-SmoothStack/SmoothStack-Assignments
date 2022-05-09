package UtopiaAirlines.BookingManager.Models;

import javax.persistence.*;

@Entity
@Table(name = "booking_user")
public class BookingUser {
    @Id
    @Column(name = "booking_id")
    private Long bookingId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @Column(name = "user_id")
    private Long userId;

    public BookingUser() {}

    public BookingUser(Booking booking, Long userId) {
        this.bookingId = booking.getId();
        this.booking = booking;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BookingUser) {
            BookingUser toCompare = (BookingUser) o;
            if (this.bookingId.equals(toCompare.bookingId) && this.booking.equals(toCompare.booking)
                    && this.userId.equals(toCompare.userId))
                return true;
        }
        return false;
    }
}