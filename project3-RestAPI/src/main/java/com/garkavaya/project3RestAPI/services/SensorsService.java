package com.garkavaya.project3RestAPI.services;

import com.garkavaya.project3RestAPI.models.Sensor;
import com.garkavaya.project3RestAPI.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorsService {
    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    @Transactional
    public void register(Sensor sensor) {
        sensorsRepository.save(sensor);
    }

    public Optional<Sensor> findByName(String name) {
        return sensorsRepository.findByName(name);
    }
}
