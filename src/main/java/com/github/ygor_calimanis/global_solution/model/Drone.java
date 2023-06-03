package com.github.ygor_calimanis.global_solution.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "Drones")
public class Drone {
    // Dados do drone
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Modelo")
    private String model;

    // Licença para voar
    @Column(name = "Serial")
    private Long serialNum;
    @Column(name = "Emissao")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate emission;
    @Column(name = "Validade")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate expDate; //validade

    // Histórico de voo
    @Column(name = "DataHora")
    @JsonFormat(pattern = "yyyy/MM/dd - HH:mm:ss")
    private LocalDateTime flight_date;
    @Column(name = "Duração")
    @JsonFormat(pattern="HH:mm:ss")
    private String flight_length;
    @Column(name = "Coord_Inicio")
    private double startCoord;
    @Column(name = "Coord_Fim")
    private double endCoord;
    @Column(name = "Altitude")
    private int altitude;
    @Column(name = "Velociade_Medio")
    private double speed_avg;

    @Column(name = "Horas_Voo")
    @JsonFormat(pattern="HH:mm:ss")
    private String fligthHours;
    @Column(name = "Capacidade_Carga")
    private double cargoCapacity;
    @Column(name = "Capacidade_Bateria")
    private double batteryCapacity;
}