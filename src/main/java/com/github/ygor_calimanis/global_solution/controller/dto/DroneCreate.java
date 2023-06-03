package com.github.ygor_calimanis.global_solution.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class DroneCreate {
	private String model;
	private Long serialNum;
	private LocalDate emission;
	private LocalDate expDate; //validade

	// Histórico de voo
	private LocalDateTime flight_date;
	private String flight_length;
	private double startCoord;
	private double endCoord;
	private int altitude;
	private double speed_avg;

	private String fligthHours;
	private double cargoCapacity;
	private double batteryCapacity;
}
