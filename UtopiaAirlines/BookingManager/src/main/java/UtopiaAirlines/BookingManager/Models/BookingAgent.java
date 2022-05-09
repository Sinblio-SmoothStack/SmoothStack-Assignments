package UtopiaAirlines.BookingManager.Models;

import javax.persistence.*;

@Entity
@Table(name = "booking_agent")
public class BookingAgent {
    @Id
    @Column(name = "booking_id")
    private Long bookingId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @Column(name = "agent_id")
    private Long agentId;

    public BookingAgent() {}

    public BookingAgent(Booking booking, Long agentId) {
        this.bookingId = booking.getId();
        this.booking = booking;
        this.agentId = agentId;
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

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BookingAgent) {
            BookingAgent toCompare = (BookingAgent) o;
            if (this.bookingId.equals(toCompare.bookingId) && this.booking.equals(toCompare.booking)
                    && this.agentId.equals(toCompare.agentId))
                return true;
        }
        return false;
    }
}