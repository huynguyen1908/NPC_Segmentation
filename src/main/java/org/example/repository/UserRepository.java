package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("SELECT u.username FROM User u WHERE u.id = :userId")
    String getUsernameByUserId(Integer userId);

    Boolean existsByEmail(String email);
}
