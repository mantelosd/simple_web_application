package main.controller;

import main.dto.UserDetailsDto;
import main.dto.UserNameDto;
import main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {


    private final UserRepository repository;

    private UserRepository userRepository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/names")
    public List<UserNameDto> getAllNamesAndSurnames() {
        return repository.findAllNamesAndSurnames();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsDto> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserDetailsDto userdetails = new UserDetailsDto(user.get().getId(), user.get().getName(), user.get().getSurname());
            userdetails.setBirthdate(user.get().getBirthdate());
            userdetails.setGender(user.get().getGender());
            userdetails.setHomeAddress(user.get().getAddress().getHomeAddress());
            userdetails.setWorkAddress(user.get().getAddress().getWorkAddress());
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
            return ResponseEntity.ok(userdetails);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

//        if (userRepository.existsByEmail(user.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body("Email already exists");
//        }

        // Password should be hashed here in real applications
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}