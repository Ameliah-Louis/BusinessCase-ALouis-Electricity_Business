package controller;

import model.RechargeLocation;
import model.Station;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.StationRepository;

import java.util.List;

@RestController
@RequestMapping("/api/station")
public class StationController {

    private StationRepository stationRepository;

    //injection de dépendance dans le controller
    public StationController(StationRepository stationRepository) {

        this.stationRepository = stationRepository;
    }

    public List<Station> findByUserId(String userId) {

        return this.stationRepository.findAll();
    }
}

