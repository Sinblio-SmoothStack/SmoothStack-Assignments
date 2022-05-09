package UtopiaAirlines.BookingManager.Controllers;

import UtopiaAirlines.BookingManager.Repositories.BookingAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path= "/booking-agent")
public class BookingAgent {
    @Autowired
    BookingAgentRepository bookingAgentRepository;

    @PostMapping(path = "/add")
    public void create(@RequestBody BookingAgent bookingAgent) {

    }
}
