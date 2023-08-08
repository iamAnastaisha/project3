package com.garkavaya.project3RestAPI.dto;

import jakarta.validation.constraints.*;

public class MeasurementDTO {

    @NotNull(message = "Value shouldn't be empty")
    @Min(value = -100, message = "Value should be more than -100")
    @Max(value = 100, message = "Value should be less than 100")
    private Double value;

    @NotNull(message = "Raining shouldn't be empty")
    private Boolean isRaining;

    @NotNull(message = "Sensor shouldn't be empty")
    private SensorDTO sensor;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return isRaining;
    }

    public void setRaining(Boolean isRaining) {
        this.isRaining = isRaining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
