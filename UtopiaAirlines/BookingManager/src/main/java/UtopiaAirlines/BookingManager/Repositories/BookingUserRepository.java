package UtopiaAirlines.BookingManager.Repositories;

import UtopiaAirlines.BookingManager.Models.BookingUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingUserRepository extends JpaRepository<BookingUser, Long> {
}