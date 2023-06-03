package com.github.ygor_calimanis.global_solution.controller;

import com.github.ygor_calimanis.global_solution.controller.dto.DroneRequestCreate;
import com.github.ygor_calimanis.global_solution.controller.dto.DroneRequestUpdate;
import com.github.ygor_calimanis.global_solution.controller.dto.SearchDrone;
import com.github.ygor_calimanis.global_solution.controller.telemetriaDto.SearchTelemetria;
import com.github.ygor_calimanis.global_solution.controller.telemetriaDto.TelemetriaRequestCreate;
import com.github.ygor_calimanis.global_solution.controller.telemetriaDto.TelemetriaRequestUpdate;
import com.github.ygor_calimanis.global_solution.model.Drone;
import com.github.ygor_calimanis.global_solution.model.Telemetria;
import com.github.ygor_calimanis.global_solution.repository.DroneRepository;
import com.github.ygor_calimanis.global_solution.repository.TelemetriaRepository;
import com.github.ygor_calimanis.global_solution.service.DroneService;
import com.github.ygor_calimanis.global_solution.service.TelemetriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/telemetria")
public class TelemetriaController {
    // swagger ui doc
    @Autowired
    private TelemetriaService telemetriaService;
    @Autowired
    private TelemetriaRepository telemetriaRepository;

    // listagem dos dados
    @GetMapping
    public ResponseEntity<List<SearchTelemetria>> listAll() {
        List<SearchTelemetria> result =
                telemetriaService.list().stream().map(SearchTelemetria::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    // cadastro dos dados
    @PostMapping
    public ResponseEntity<Telemetria> create(@RequestBody TelemetriaRequestCreate dto) {
        Telemetria telemetria = new Telemetria();
        telemetria.setLatitude(dto.getLatitude());
        telemetria.setLongitude(dto.getLongitude());
        telemetria.setAltitude(dto.getAltitude());
        telemetria.setSpeed(dto.getSpeed());
        telemetria.setDirection(dto.getDirection());
        telemetria.setTime(dto.getTime());

        Telemetria result = telemetriaService.save(telemetria);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // alteração dos dados
    @PutMapping
    public ResponseEntity<Telemetria> update(@RequestBody TelemetriaRequestUpdate dto) {

        // verifica se o id já foi informado

        boolean exists = telemetriaRepository.existsById(dto.getId());
        if (!exists) {
            return ResponseEntity.notFound().build();
        }

        Telemetria telemetria = new Telemetria();
        // mapping
        telemetria.setId(dto.getId());
        telemetria.setLatitude(dto.getLatitude());
        telemetria.setLongitude(dto.getLongitude());
        telemetria.setAltitude(dto.getAltitude());
        telemetria.setSpeed(dto.getSpeed());
        telemetria.setDirection(dto.getDirection());
        telemetria.setTime(dto.getTime());

        Telemetria result = telemetriaService.save(telemetria);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    // deleta os dados

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        boolean exists = telemetriaRepository.existsById(id);
        if (!exists) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("ID not found");
        }
        telemetriaRepository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
