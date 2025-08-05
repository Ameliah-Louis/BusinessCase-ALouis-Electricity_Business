package repository;

import model.RechargeLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RechargeLocationRepository extends JpaRepository<RechargeLocation,String> {
    //De base spring possède des méthodes de CRUD et de requête BDD
}
