package com.tus.characters.repository;

import com.tus.characters.entity.Character;
import com.tus.characters.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface CharactersRepository extends JpaRepository<Character, Long> {

    List<Character> findByUser(User user);

    // For date range (all results)
    List<Character> findByCreationDateBetween(LocalDate startDate, LocalDate endDate);

    // For paginated date range
    List<Character> findByCreationDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
    
 // Pagination for all characters
    Page<Character> findAll(Pageable pageable);

    // Get all characters for a user with pagination
    Page<Character> findByUser(User user, Pageable pageable);
}