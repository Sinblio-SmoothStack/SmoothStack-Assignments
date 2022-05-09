package UtopiaAirlines.FlightManager.Repositories;

import UtopiaAirlines.FlightManager.Models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
    Optional<Airport> findByCity(String City);
}