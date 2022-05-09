package UtopiaAirlines.UserManager.Controllers;

import UtopiaAirlines.UserManager.Models.User;
import UtopiaAirlines.UserManager.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/add")
    public void create(@RequestBody User user) {
        User createdUser = userRepository.save(user);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/id/{id}")
    public @ResponseBody User getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }
}
