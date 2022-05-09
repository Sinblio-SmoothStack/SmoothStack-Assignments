package UtopiaAirlines.BookingManager.Models;

import javax.persistence.*;

@Entity
@Table(name = "booking_payment")
public class BookingPayment {
    @Id
    @Column(name = "booking_id")
    private Long bookingId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @Column(name = "stripe_id")
    private String stripeId;

    @Column(name = "refunded")
    private Boolean refunded;

    public BookingPayment() {}

    public BookingPayment(Booking booking, String stripeId, Boolean refunded) {
        this.bookingId = booking.getId();
        this.booking = booking;
        this.stripeId = stripeId;
        this.refunded = refunded;
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

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof BookingPayment) {
            BookingPayment toCompare = (BookingPayment) o;
            if (this.bookingId.equals(toCompare.bookingId) && this.booking.equals(toCompare.booking)
                    && this.stripeId.equals(toCompare.stripeId) && this.refunded.equals(toCompare.refunded))
                return true;
        }
        return false;
    }
}