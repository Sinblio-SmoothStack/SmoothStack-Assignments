package Utopia.Airlines.Controllers;

import Utopia.Airlines.Models.User;
import Utopia.Airlines.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/user")
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

    @GetMapping(path = "/{id}")
    public @ResponseBody User getUser(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }
}