package UtopiaAirlines.FlightManager.RepositoryTests;

import UtopiaAirlines.FlightManager.Models.*;
import UtopiaAirlines.FlightManager.Repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@SpringBootTest
public class FlightTest {
    @Autowired
    AirportRepository airportRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    AirplaneTypeRepository airplaneTypeRepository;
    @Autowired
    AirplaneRepository airplaneRepository;
    @Autowired
    FlightRepository flightRepository;

    @Test
    void crudTest() {
        //Test Data For Other Tables
        Airport testAirport1 = new Airport("TAA", "Test Airport Alpha");
        Airport testAirport2 = new Airport("TAB", "Test Airport Bravo");
        Airport testAirport3 = new Airport("TAC", "Test Airport Charlie");

        airportRepository.save(testAirport1);
        airportRepository.save(testAirport2);
        airportRepository.save(testAirport3);
        airportRepository.flush();

        Route testRoute = new Route();
        testRoute.setOriginAirport(testAirport1);
        testRoute.setDestinationAirport(testAirport2);

        routeRepository.save(testRoute);
        routeRepository.flush();

        AirplaneType testAirplaneType1 = new AirplaneType(2, 6, 10);
        AirplaneType testAirplaneType2 = new AirplaneType(0, 4, 12);

        airplaneTypeRepository.save(testAirplaneType1);
        airplaneTypeRepository.save(testAirplaneType2);
        airplaneTypeRepository.flush();

        Airplane testAirplane1 = new Airplane(testAirplaneType1);
        Airplane testAirplane2 = new Airplane(testAirplaneType2);

        airplaneRepository.save(testAirplane1);
        airplaneRepository.save(testAirplane2);
        airplaneRepository.flush();

        //Creation Test

        Flight testFlight1 = new Flight(testRoute, testAirplane1, LocalDateTime.now(),
                1, 2, 3,
                12, 50, 100);

        Flight testFlight2 = new Flight(testRoute, testAirplane1, LocalDateTime.now(),
                0, 0, 0,
                100, 500, 1000);

        flightRepository.save(testFlight1);
        flightRepository.save(testFlight2);
        flightRepository.flush();

        List<Flight> flights = flightRepository.findAll();

        assert(flights.contains(testFlight1));
        assert(flights.contains(testFlight2));

        // Read & Update Test

        LocalDateTime newDepartureTime = LocalDateTime.now();

        testFlight1.setDepartureTime(newDepartureTime);

        flightRepository.save(testFlight1);

        Flight flight = flightRepository.getById(testFlight1.getId());

        assert(flight.getDepartureTime().equals(newDepartureTime));

        // Deletion Test

        flightRepository.deleteAll();

        assert(flightRepository.findAll().isEmpty());
    }
}
