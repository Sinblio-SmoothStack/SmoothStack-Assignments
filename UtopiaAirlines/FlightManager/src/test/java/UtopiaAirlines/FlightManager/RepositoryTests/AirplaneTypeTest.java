package UtopiaAirlines.FlightManager.RepositoryTests;

import UtopiaAirlines.FlightManager.Models.AirplaneType;
import UtopiaAirlines.FlightManager.Repositories.AirplaneTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@SpringBootTest
public class AirplaneTypeTest {
    @Autowired
    AirplaneTypeRepository airplaneTypeRepository;

    @Test
    void crudTest() {
        //Creation Test
        AirplaneType testAirplaneType1 = new AirplaneType(2, 6, 10);
        AirplaneType testAirplaneType2 = new AirplaneType(0, 4, 12);

        airplaneTypeRepository.save(testAirplaneType1);
        airplaneTypeRepository.save(testAirplaneType2);
        airplaneTypeRepository.flush();

        List<AirplaneType> airplaneTypes = airplaneTypeRepository.findAll();

        assert(airplaneTypes.contains(testAirplaneType1));
        assert(airplaneTypes.contains(testAirplaneType2));

        //Read & Update Test
        testAirplaneType2.setMaxCapacityBusiness(0);
        testAirplaneType2.setMaxCapacityEconomy(20);

        airplaneTypeRepository.save(testAirplaneType2);

        AirplaneType airplaneType = airplaneTypeRepository.getById(testAirplaneType2.getId());

        assert(airplaneType.getMaxCapacityBusiness() == 0 && airplaneType.getMaxCapacityEconomy() == 20);

        //Delete Test

        airplaneTypeRepository.deleteAll();

        assert(airplaneTypeRepository.findAll().isEmpty());
    }
}
