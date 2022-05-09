package UtopiaAirlines.UserManager.RepositoryTests;

import UtopiaAirlines.UserManager.Models.User;
import UtopiaAirlines.UserManager.Models.UserRole;
import UtopiaAirlines.UserManager.Repositories.UserRepository;
import UtopiaAirlines.UserManager.Repositories.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@SpringBootTest
public class UserTest {
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void crudTest() {
        // Test Data For Other Tables
        UserRole testRole1 = new UserRole("Test Role 1");
        UserRole testRole2 = new UserRole("Test Role 2");

        userRoleRepository.save(testRole1);
        userRoleRepository.save(testRole2);
        userRoleRepository.flush();

        // Creation Test

        User testUser1 = new User(testRole1, "Benjamin", "Schroeder", "Sinblio",
                "schroeder.ben380@gmail.com", "aPassword", "3198553540");
        User testUser2 = new User(testRole2, "Someone", "Else", "SomeoneElse",
                "someone.else@gmail.com", "aDifferentPassword", "1234567890");

        userRepository.save(testUser1);
        userRepository.save(testUser2);
        userRepository.flush();

        List<User> users = userRepository.findAll();

        assert(users.contains(testUser1));
        assert(users.contains(testUser2));

        // Read & Update Test
        String newEmail = "a.new.email@gmail.com";

        testUser2.setEmail(newEmail);

        userRepository.save(testUser2);

        User user = userRepository.getById(testUser2.getId());

        assert(user.getEmail().equals(newEmail));

        // Deletion Test

        userRepository.deleteAll();

        assert(userRepository.findAll().isEmpty());
    }
}
