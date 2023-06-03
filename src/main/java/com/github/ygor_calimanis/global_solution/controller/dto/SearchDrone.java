package com.github.ygor_calimanis.global_solution.controller.dto;

import com.github.ygor_calimanis.global_solution.model.Drone;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class SearchDrone {
	private Long id;
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

	public static  SearchDrone toDto(Drone drone){
		SearchDrone dto = new SearchDrone();
		dto.setId(drone.getId());
		dto.setModel(drone.getModel());
		dto.setSerialNum(drone.getSerialNum());
		dto.setEmission(drone.getEmission());
		dto.setExpDate(drone.getExpDate());
		dto.setFlight_date(drone.getFlight_date());
		dto.setFlight_length(drone.getFlight_length());
		dto.setStartCoord(drone.getStartCoord());
		dto.setEndCoord(drone.getEndCoord());
		dto.setAltitude(drone.getAltitude());
		dto.setSpeed_avg(drone.getSpeed_avg());
		dto.setFligthHours(drone.getFligthHours());
		dto.setCargoCapacity(drone.getCargoCapacity());
		dto.setBatteryCapacity(drone.getBatteryCapacity());
		return dto;
	}
}
