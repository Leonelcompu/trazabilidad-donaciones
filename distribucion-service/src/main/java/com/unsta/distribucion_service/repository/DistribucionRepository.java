package com.unsta.distribucion_service.repository;

import com.unsta.distribucion_service.model.Distribucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistribucionRepository extends JpaRepository<Distribucion, Long> {
}