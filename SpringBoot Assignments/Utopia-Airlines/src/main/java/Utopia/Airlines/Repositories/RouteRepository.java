package Utopia.Airlines.Repositories;

import Utopia.Airlines.Models.Airport;
import Utopia.Airlines.Models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAllByOriginAirport(Airport origin);
    List<Route> findAllByDestinationAirport(Airport destination);
}
