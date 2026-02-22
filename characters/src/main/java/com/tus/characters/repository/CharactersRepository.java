package com.tus.characters.repository;

import com.tus.characters.entity.Character;
import com.tus.characters.entity.User;
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
}