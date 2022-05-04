package Utopia.Airlines.Repositories;

import Utopia.Airlines.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}