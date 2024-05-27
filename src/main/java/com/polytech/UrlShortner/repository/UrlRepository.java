package com.polytech.UrlShortner.repository;

import com.polytech.UrlShortner.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortLink(String shortLink);




}
