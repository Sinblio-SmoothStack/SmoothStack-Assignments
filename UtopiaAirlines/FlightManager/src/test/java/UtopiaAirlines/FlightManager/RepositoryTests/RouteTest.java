package UtopiaAirlines.FlightManager.RepositoryTests;

import UtopiaAirlines.FlightManager.Models.Airport;
import UtopiaAirlines.FlightManager.Models.Route;
import UtopiaAirlines.FlightManager.Repositories.AirportRepository;
import UtopiaAirlines.FlightManager.Repositories.RouteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@SpringBootTest
public class RouteTest {
    @Autowired
    AirportRepository airportRepository;
    @Autowired
    RouteRepository routeRepository;

    @Test
    void crudTest() {
        Airport testAirport1 = new Airport("TAA", "Test Airport Alpha");
        Airport testAirport2 = new Airport("TAB", "Test Airport Bravo");
        Airport testAirport3 = new Airport("TAC", "Test Airport Charlie");

        airportRepository.save(testAirport1);
        airportRepository.save(testAirport2);
        airportRepository.save(testAirport3);
        airportRepository.flush();

        //Creation Test
        Route testRoute = new Route();
        testRoute.setOriginAirport(testAirport1);
        testRoute.setDestinationAirport(testAirport2);

        routeRepository.save(testRoute);
        routeRepository.flush();

        List<Route> routes = routeRepository.findAll();

        assert (routes.contains(testRoute));

        //Read and Update Test

        testRoute.setDestinationAirport(testAirport3);

        routeRepository.save(testRoute);

        assert(!routeRepository.findAllByDestinationAirport(testAirport3).isEmpty());

        //Delete Test

        routeRepository.deleteAll();

        assert (routeRepository.findAll().isEmpty());
    }
}
