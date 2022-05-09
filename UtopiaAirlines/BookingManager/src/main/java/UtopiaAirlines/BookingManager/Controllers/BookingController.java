package UtopiaAirlines.BookingManager.Controllers;

import UtopiaAirlines.BookingManager.Models.Booking;
import UtopiaAirlines.BookingManager.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@CrossOrigin
@RestController
@RequestMapping(path = "/booking")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @PostMapping(path="/add")
    public void create(@RequestBody Booking booking) {
        Booking createdBooking = bookingRepository.save(booking);
    }

    @GetMapping(path= "/all")
    public @ResponseBody Iterable<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping(path = "/id={id}")
    public @ResponseBody Booking getBookingById(@PathVariable("id") Long id) {
        return  bookingRepository.getById(id);
    }
}
