package UtopiaAirlines.FlightManager.Controllers;

import UtopiaAirlines.FlightManager.Models.Airport;
import UtopiaAirlines.FlightManager.Repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/airport")
public class AirportController {
    @Autowired
    AirportRepository airportRepository;

    @PostMapping(path = "/add")
    public void create(@RequestBody Airport airport) {
        Airport createdAirport = airportRepository.save(airport);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @GetMapping(path = "/id={id}")
    public @ResponseBody Optional<Airport> getAirport(@PathVariable("id") String id) {
        return airportRepository.findById(id);
    }

}
