package controller;

import model.RechargeLocation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.RechargeLocationRepository;

import java.util.List;

@RestController
@RequestMapping("/api/recharge_location")
public class RechargeLocationController {

    private RechargeLocationRepository rechargeLocationRepository;

    //injection de dépendance dans le controller
    public RechargeLocationController(RechargeLocationRepository rechargeLocationRepository) {
        this.rechargeLocationRepository = rechargeLocationRepository;
    }

    public List<RechargeLocation> findByUserId(String userId) {
        return this.rechargeLocationRepository.findAll();
    }

}
