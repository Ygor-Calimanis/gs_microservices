package com.github.ygor_calimanis.global_solution.controller.telemetriaDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.ygor_calimanis.global_solution.controller.dto.SearchDrone;
import com.github.ygor_calimanis.global_solution.model.Drone;
import com.github.ygor_calimanis.global_solution.model.Telemetria;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class SearchTelemetria {
    private double latitude;
    private double longitude;
    private int altitude;
    private int speed;
    private int direction;
    private LocalDateTime time;

    public static SearchTelemetria toDto(Telemetria telemetria) {
        SearchTelemetria dto = new SearchTelemetria();
        dto.setLatitude(telemetria.getLatitude());
        dto.setLongitude(telemetria.getLongitude());
        dto.setAltitude(telemetria.getAltitude());
        dto.setSpeed(telemetria.getSpeed());
        dto.setDirection(telemetria.getDirection());
        dto.setTime(telemetria.getTime());
        return dto;
    }

}
