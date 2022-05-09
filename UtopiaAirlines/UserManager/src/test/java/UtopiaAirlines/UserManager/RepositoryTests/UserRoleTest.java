package UtopiaAirlines.UserManager.RepositoryTests;

import UtopiaAirlines.UserManager.Models.UserRole;
import UtopiaAirlines.UserManager.Repositories.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@SpringBootTest
public class UserRoleTest {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Test
    void crudTest() {
        //Create Test
        UserRole testRole1 = new UserRole("Test Role 1");
        UserRole testRole2 = new UserRole("Test Role 2");

        userRoleRepository.save(testRole1);
        userRoleRepository.save(testRole2);
        userRoleRepository.flush();

        List<UserRole> userRoles = userRoleRepository.findAll();

        assert(userRoles.contains(testRole1));
        assert(userRoles.contains(testRole2));

        // Read & Update Test

        String newName = "New Test Name";
        testRole1.setName(newName);

        userRoleRepository.save(testRole1);

        UserRole userRole = userRoleRepository.getById(testRole1.getId());

        assert(userRole.getName().equals(newName));

        // Delete Test

        userRoleRepository.deleteAll();

        assert(userRoleRepository.findAll().isEmpty());
    }
}
