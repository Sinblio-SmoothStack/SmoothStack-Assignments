package Utopia.Airlines.Controllers;

import Utopia.Airlines.Models.Airport;
import Utopia.Airlines.Repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Airport")
public class AirportController {
    @Autowired
    AirportRepository airportRepository;

    @PostMapping(path = "/add")
    public void create(@RequestBody Airport airport) {
        Airport createdAirport = airportRepository.save(airport);
    }

    @RequestMapping(path = "/hello")
    public String getHello() {
        return "Hello There";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

}
