package com.github.ygor_calimanis.global_solution.repository;

import com.github.ygor_calimanis.global_solution.model.Telemetria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelemetriaRepository
        extends JpaRepository<Telemetria, Long> {

}