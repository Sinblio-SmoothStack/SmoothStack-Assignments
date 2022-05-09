package UtopiaAirlines.BookingManager.Repositories;

import UtopiaAirlines.BookingManager.Models.BookingGuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingGuestRepository extends JpaRepository<BookingGuest, Long> {
}