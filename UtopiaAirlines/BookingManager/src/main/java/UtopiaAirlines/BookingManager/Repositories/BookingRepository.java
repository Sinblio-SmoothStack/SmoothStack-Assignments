package UtopiaAirlines.BookingManager.Repositories;

import UtopiaAirlines.BookingManager.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}