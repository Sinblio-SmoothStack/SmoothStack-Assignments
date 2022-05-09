package UtopiaAirlines.BookingManager.Repositories;

import UtopiaAirlines.BookingManager.Models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}