package controller;

import model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userRepository;

    //injection de dépendance dans le controller
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User>  findAll(){
        return this.userRepository.findAll();
    }
}
