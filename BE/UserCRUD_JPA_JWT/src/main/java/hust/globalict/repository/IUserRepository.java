package hust.globalict.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hust.globalict.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}
