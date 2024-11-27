package com.example.temat2.repository;

import com.example.temat2.domain.WeatherData;
import com.example.temat2.domain.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

@RepositoryRestResource(collectionResourceRel = "forecasts", path = "forecasts")
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    // Wyszukiwanie danych pogodowych nowszych niż podana data oraz wg lokalizacji, wyniki stronicowane
    Page<WeatherData> findByTimestampGreaterThanEqualAndLocation(
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date,
            Location location,
            Pageable pageable
    );
}
