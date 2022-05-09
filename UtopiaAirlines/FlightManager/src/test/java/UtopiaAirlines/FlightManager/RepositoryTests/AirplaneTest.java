package UtopiaAirlines.FlightManager.RepositoryTests;

import UtopiaAirlines.FlightManager.Models.Airplane;
import UtopiaAirlines.FlightManager.Models.AirplaneType;
import UtopiaAirlines.FlightManager.Repositories.AirplaneRepository;
import UtopiaAirlines.FlightManager.Repositories.AirplaneTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@SpringBootTest
public class AirplaneTest {
    @Autowired
    AirplaneTypeRepository airplaneTypeRepository;
    @Autowired
    AirplaneRepository airplaneRepository;

    @Test
    void crudTest() {
        //Test Data For Other Tables
        AirplaneType testAirplaneType1 = new AirplaneType(2, 6, 10);
        AirplaneType testAirplaneType2 = new AirplaneType(0, 4, 12);

        airplaneTypeRepository.save(testAirplaneType1);
        airplaneTypeRepository.save(testAirplaneType2);
        airplaneTypeRepository.flush();

        //Creation Test
        Airplane testAirplane1 = new Airplane(testAirplaneType1);
        Airplane testAirplane2 = new Airplane(testAirplaneType2);

        airplaneRepository.save(testAirplane1);
        airplaneRepository.save(testAirplane2);
        airplaneRepository.flush();

        List<Airplane> airplanes = airplaneRepository.findAll();

        assert(airplanes.contains(testAirplane1));
        assert(airplanes.contains(testAirplane2));

        //Read & Update Test

        testAirplane2.setAirplaneType(testAirplaneType1);

        airplaneRepository.save(testAirplane2);

        Airplane airplane = airplaneRepository.getById(testAirplane2.getId());

        assert(airplane.getAirplaneType().equals(testAirplaneType1));

        //Deletion Test

        airplaneRepository.deleteAll();

        assert(airplaneRepository.findAll().isEmpty());

    }
}
