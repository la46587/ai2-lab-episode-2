package com.example.temat2.repository;

import com.example.temat2.domain.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "locations", path = "locations")
public interface LocationRepository extends JpaRepository<Location, Long> {

    // Wyszukiwanie lokalizacji wg nazwy kraju, wyniki stronicowane
    @RestResource(path = "findByCountry", rel = "findByCountry")
    Page<Location> findByCountryContainingIgnoreCase(String country, Pageable pageable);

    // Znajdowanie pojedynczej lokalizacji wg nazwy miasta
    Optional<Location> findByName(String name);
}
