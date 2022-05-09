package UtopiaAirlines.BookingManager.Repositories;

import UtopiaAirlines.BookingManager.Models.BookingAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingAgentRepository extends JpaRepository<BookingAgent, Long> {
}