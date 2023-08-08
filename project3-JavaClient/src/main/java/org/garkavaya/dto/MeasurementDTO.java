package org.garkavaya.dto;


public class MeasurementDTO {
    private Double value;
    private Boolean isRaining;
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

    @Override
    public String toString() {
        return "Measurement {" +
                "value = " + value +
                ", isRaining = " + isRaining +
                ", sensor = " + sensor +
                "}\n";
    }
}
