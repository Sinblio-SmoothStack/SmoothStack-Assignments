package UtopiaAirlines.BookingManager.Repositories;

import UtopiaAirlines.BookingManager.Models.BookingPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingPaymentRepository extends JpaRepository<BookingPayment, Long> {
}