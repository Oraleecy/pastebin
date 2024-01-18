package com.example.pastebin.repositories;

import com.example.pastebin.models.ShortUrlGeneratorSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ShortUrlGeneratorSequenceRepository extends JpaRepository<ShortUrlGeneratorSequence, Long> {
    @Query(value="SELECT nextval('url_generator_sequence')", nativeQuery = true)
    public Long getNextValue();
}
