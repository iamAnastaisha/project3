package com.garkavaya.project3RestAPI.repositories;

import com.garkavaya.project3RestAPI.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {
    int countByRaining(Boolean isRaining);
}
