package main.repository;

import main.dto.UserNameDto;
import main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new main.dto.UserNameDto(u.id, u.name, u.surname) FROM User u")
    List<UserNameDto> findAllNamesAndSurnames();

    Optional<User> findByNameAndSurname(String name, String surname);
}