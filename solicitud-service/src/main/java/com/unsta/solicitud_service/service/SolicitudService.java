package com.unsta.solicitud_service.service;

import com.unsta.solicitud_service.model.Solicitud;
import com.unsta.solicitud_service.repository.SolicitudRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SolicitudService {

    private final SolicitudRepository repository;

    public SolicitudService(SolicitudRepository repository) {
        this.repository = repository;
    }

    public List<Solicitud> listarTodas() {
        return repository.findAll();
    }

    public Solicitud guardar(Solicitud solicitud) {
        solicitud.setId(null);
        if (solicitud.getFechaSolicitud() == null) {
            solicitud.setFechaSolicitud(LocalDateTime.now());
        }
        if (solicitud.getEstado() == null || solicitud.getEstado().isBlank()) {
            solicitud.setEstado("PENDIENTE");
        }
        if (solicitud.getPrioridad() == null || solicitud.getPrioridad().isBlank()) {
            solicitud.setPrioridad("MEDIA");
        }
        return repository.save(solicitud);
    }
}