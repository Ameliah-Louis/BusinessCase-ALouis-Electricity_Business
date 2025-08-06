package repository;

import model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
    //De base spring possède des méthodes de CRUD et de requête BDD
}