package com.unsta.solicitud_service.repository;

import com.unsta.solicitud_service.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}