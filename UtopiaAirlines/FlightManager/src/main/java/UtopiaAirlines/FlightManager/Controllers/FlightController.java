package UtopiaAirlines.FlightManager.Controllers;

import UtopiaAirlines.FlightManager.Models.Flight;
import UtopiaAirlines.FlightManager.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/flight")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @PostMapping(path = "/add")
    public void create(@RequestBody Flight flight) {
        Flight createdFlight = flightRepository.save(flight);
    }

    @GetMapping(path= "/all")
    public @ResponseBody Iterable<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @GetMapping(path = "/id={id}")
    public @ResponseBody Flight getFlightById(@PathVariable("id") Long id) {
        return flightRepository.getById(id);
    }
}
