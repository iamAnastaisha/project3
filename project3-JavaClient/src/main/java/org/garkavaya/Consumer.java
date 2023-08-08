package org.garkavaya;

import org.garkavaya.dto.MeasurementResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;


public class Consumer {
    public static void main( String[] args ) {
        String sensorName = "sensor";

        registerSensor(sensorName);

        for (int i = 0; i < 10; i++) {
            addMeasurement(sensorName);
        }

        MeasurementResponse response = getMeasurements();
        System.out.println(response);
    }

    private static void registerSensor(String sensorName) {
        String registerUrl = "http://localhost:8080/sensors/registration";

        Map<String, Object> jsonToSend = new HashMap<>();
        jsonToSend.put("name", sensorName);

        makePostRequest(registerUrl, jsonToSend);

    }

    private static void addMeasurement(String sensorName) {
        String addMeasurementUrl = "http://localhost:8080/measurements/add";
        Map<String, Object> jsonToSend = new HashMap<>();

        Random random = new Random();
        jsonToSend.put("value", random.nextDouble() * 200 - 100);
        jsonToSend.put("raining", random.nextBoolean());
        jsonToSend.put("sensor", Map.of("name", sensorName));

        makePostRequest(addMeasurementUrl, jsonToSend);
    }


    private static MeasurementResponse getMeasurements() {
        String getMeasurementUrl = "http://localhost:8080/measurements";

        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(getMeasurementUrl, MeasurementResponse.class);
        } catch (RestClientException ex) {
            System.out.println("Something went wrong! " + ex.getMessage());
        }
        return null;
    }

    private static void makePostRequest(String url, Map<String, Object> jsonToSend) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);
        try {
            restTemplate.postForObject(url, request, HttpStatus.class);
            System.out.println("The changes were successful!");
        } catch (RestClientException ex) {
            System.out.println("Something went wrong! " + ex.getMessage());
        }
    }
}
