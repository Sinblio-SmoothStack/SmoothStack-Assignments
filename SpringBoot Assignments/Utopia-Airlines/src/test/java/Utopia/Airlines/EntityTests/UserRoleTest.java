package Utopia.Airlines.EntityTests;

import Utopia.Airlines.Models.UserRole;
import Utopia.Airlines.Repositories.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
public class UserRoleTest {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Test
    void crudTest() {
        //Create Test
        UserRole testRole = new UserRole("testRole");

        userRoleRepository.save(testRole);

        assert (userRoleRepository.getUserRoleByName(testRole.getName()).isPresent());

        //Update Test
        testRole.setName("newTestName");

        userRoleRepository.save(testRole);

        assert (userRoleRepository.getUserRoleByName(testRole.getName()).isPresent());

        //Remove Test
        userRoleRepository.delete(testRole);

        assert (userRoleRepository.getUserRoleByName(testRole.getName()).isEmpty());
    }
}
