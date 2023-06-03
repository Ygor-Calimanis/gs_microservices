package com.github.ygor_calimanis.global_solution.controller.telemetriaDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class TelemetriaRequestCreate {
	private double latitude;
	private double longitude;
	private int altitude;
	private int speed;
	private int direction;
	private LocalDateTime time;
}

