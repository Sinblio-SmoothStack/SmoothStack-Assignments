package UtopiaAirlines.FlightManager.RepositoryTests;

import UtopiaAirlines.FlightManager.Models.Airport;
import UtopiaAirlines.FlightManager.Repositories.AirportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@SpringBootTest
public class AirportTest {
    @Autowired
    AirportRepository airportRepository;

    @Test
    void crudTest() {
        //Creation Test
        Airport testAirport1 = new Airport("TAA", "Test Airport Alpha");
        Airport testAirport2 = new Airport("TAB", "Test Airport Bravo");
        Airport testAirport3 = new Airport("TAC", "Test Airport Charlie");

        airportRepository.save(testAirport1);
        airportRepository.save(testAirport2);
        airportRepository.save(testAirport3);
        airportRepository.flush();

        List<Airport> airports = airportRepository.findAll();

        assert (airports.contains(testAirport1));
        assert (airports.contains(testAirport2));
        assert (airports.contains(testAirport3));

        //Read Test
        Optional<Airport> oldAirport = airportRepository.findById("TAC");

        assert (oldAirport.isPresent());

        //Update Test
        Airport airport = oldAirport.get();

        airport.setCity("Test Airport Chris");

        airportRepository.save(airport);

        Optional<Airport> updatedAirport = airportRepository.findById("TAC");

        assert (airport.equals(updatedAirport.get()));

        //Delete Test
        airportRepository.delete(testAirport3);

        assert(!airportRepository.existsById(testAirport3.getId()));

        airportRepository.deleteAll();

        List<Airport> allAirports = airportRepository.findAll();

        assert (allAirports.isEmpty());
    }
}
