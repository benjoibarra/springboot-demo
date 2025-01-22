package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT CASE WHEN (SELECT COUNT(u) FROM User u) < :count THEN true ELSE false END") //<< JPQL
    //@Query(value = "SELECT CASE WHEN (SELECT COUNT(*) FROM users) < :count THEN true ELSE false END", nativeQuery = true)
    boolean isUserCountLessThan(long count);
}
