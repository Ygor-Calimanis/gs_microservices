package com.github.ygor_calimanis.global_solution.service;

import java.util.List;

import com.github.ygor_calimanis.global_solution.model.Telemetria;
import com.github.ygor_calimanis.global_solution.repository.TelemetriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TelemetriaService {

    @Autowired
    private TelemetriaRepository telemetriaRepository;

    public List<Telemetria> list() {
        return telemetriaRepository.findAll();
    }

    public Telemetria save(Telemetria telemetria) {
        return telemetriaRepository.save(telemetria);
    }
}
