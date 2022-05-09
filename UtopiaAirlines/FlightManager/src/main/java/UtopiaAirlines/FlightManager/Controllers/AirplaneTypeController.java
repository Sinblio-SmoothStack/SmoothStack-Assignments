package UtopiaAirlines.FlightManager.Controllers;

import UtopiaAirlines.FlightManager.Models.AirplaneType;
import UtopiaAirlines.FlightManager.Repositories.AirplaneTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path= "/airplane-type")
public class AirplaneTypeController {
    @Autowired
    AirplaneTypeRepository airplaneTypeRepository;

    @PostMapping(path = "/add")
    public void create(@RequestBody AirplaneType airplaneType) {
        AirplaneType createdAirplaneType = airplaneTypeRepository.save(airplaneType);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<AirplaneType> getAllAirplaneTypes() {
        return airplaneTypeRepository.findAll();
    }

    @GetMapping(path = "/id={id}")
    public @ResponseBody AirplaneType getAirplaneTypeById(@PathVariable("id") Long id) {
        return airplaneTypeRepository.getById(id);
    }
}
