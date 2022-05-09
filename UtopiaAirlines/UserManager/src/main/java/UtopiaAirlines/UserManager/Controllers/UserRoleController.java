package UtopiaAirlines.UserManager.Controllers;

import UtopiaAirlines.UserManager.Models.UserRole;
import UtopiaAirlines.UserManager.Repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/user-roles")
public class UserRoleController {
    @Autowired
    UserRoleRepository userRoleRepository;

    @PostMapping(path = "/add")
    public void create(@RequestBody UserRole userRole) {
        UserRole createdRole = userRoleRepository.save(userRole);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<UserRole> getAllRoles() {
        return userRoleRepository.findAll();
    }

    @GetMapping(path = "/name/{name}")
    public @ResponseBody
    UserRole getRoleByName(@PathVariable("name") String name) {
        return userRoleRepository.findUserRoleByName(name).get();
    }
}
