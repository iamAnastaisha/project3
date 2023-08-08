package com.garkavaya.project3RestAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
public class Measurement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @NotNull(message = "Value shouldn't be empty")
    @Min(value = -100, message = "Value should be more than -100")
    @Max(value = 100, message = "Value should be less than 100")
    private Double value;

    @Column(name = "raining")
    @NotNull(message = "Raining shouldn't be empty")
    private Boolean raining;

    @Column(name = "measurement_time")
    private LocalDateTime measurementTime;

    @NotNull(message = "Sensor shouldn't be empty")
    @ManyToOne
    @JoinColumn(name="sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    public Measurement() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean isRaining() {
        return raining;
    }

    public void setRaining(Boolean isRaining) {
        this.raining = isRaining;
    }

    public LocalDateTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(LocalDateTime measurementTime) {
        this.measurementTime = measurementTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
