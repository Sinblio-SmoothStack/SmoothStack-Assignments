package UtopiaAirlines.FlightManager.Controllers;

import UtopiaAirlines.FlightManager.Models.Airplane;
import UtopiaAirlines.FlightManager.Repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/airplane")
public class AirplaneController {
    @Autowired
    AirplaneRepository airplaneRepository;

    @PostMapping(path = "/add")
    public void create(@RequestBody Airplane airplane) {
        Airplane createdAirplane = airplaneRepository.save(airplane);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @GetMapping(path = "/id={id}")
    public @ResponseBody Airplane getAirplaneById(@PathVariable("id") Long id) {
        return airplaneRepository.getById(id);
    }
}
