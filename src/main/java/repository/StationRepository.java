package repository;

import model.RechargeLocation;
import model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,String> {
    //De base spring possède des méthodes de CRUD et de requête BDD
}