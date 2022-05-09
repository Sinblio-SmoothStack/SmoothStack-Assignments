package UtopiaAirlines.FlightManager.Controllers;

import UtopiaAirlines.FlightManager.Models.Route;
import UtopiaAirlines.FlightManager.Repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/route")
public class RouteController {
    @Autowired
    RouteRepository routeRepository;

    @PostMapping(path = "/add")
    public void create(@RequestBody Route route) {
        Route createRoute = routeRepository.save(route);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @GetMapping(path = "/id={id}")
    public @ResponseBody Route getRouteById(@PathVariable("id") Long id) {
        return routeRepository.getById(id);
    }


}
